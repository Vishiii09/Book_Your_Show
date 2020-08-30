/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.jdbc.*;
import bean.Person;
import java.util.ArrayList;
import java.sql.*;


public class PersonDao {

    public boolean add(Person person) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();

            if (con != null) {
                String sql = "Insert into person(name,contact,userid,password) values(?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, person.getName());
               smt.setString(2, person.getContact());
                smt.setString(3, person.getUserid());
                smt.setString(4, person.getPassword());
                
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Inserted !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }

    public boolean removeById(int id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Delete from person where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public boolean remove(Person person) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Delete from person where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, person.getId());

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public Person getById(int id) {
        Person person = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from person where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("name"));
                    person.setContact(rs.getString("contact"));
                    person.setUserid(rs.getString("userid"));
                    person.setPassword(rs.getString("password"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return person;
    }

    public ArrayList<Person> getAllRecords() {
        ArrayList<Person> persons = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from person";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Person person = new Person();
                    person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("name"));
                    person.setContact(rs.getString("contact"));
                    person.setUserid(rs.getString("userid"));
                    person.setPassword(rs.getString("password"));

                    persons.add(person);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return persons;
    }

    public ArrayList<Person> getRowsByLimit(int start, int end) {
        ArrayList<Person> persons = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from person limit ?,?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, end);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Person person = new Person();
                    person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("name"));
                    person.setContact(rs.getString("contact"));
                    person.setUserid(rs.getString("userid"));
                    person.setPassword(rs.getString("password"));

                    persons.add(person);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return persons;
    }

    public boolean isUseridExist(String userid) {
        boolean status = false;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from person where userid=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, userid);

                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    status = true;
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }

    public boolean update(Person person) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();

            if (con != null) {
                String sql = "update person set name=?,contact=?,userid=?,password=? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, person.getName());
                smt.setString(2, person.getContact());
                smt.setString(3, person.getUserid());
                smt.setString(4, person.getPassword());
                smt.setInt(9, person.getId());
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Updated !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public int getRecordCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();

            if (con != null) {
                String sql = "select count(*) from person";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                    System.out.println("total records : " + total);
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return total;
    }

    public static void main(String[] args) {
        PersonDao pd = new PersonDao();
        System.out.println("Total record "+ pd.getRecordCount());
    }

 public int isValid(String userid, String password) {
        int status = -1;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "select * from person where userid=? and password=? ";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, userid);
                smt.setString(2, password);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    status = rs.getInt("id");
                }
                smt.close();
                cp.putConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }

        return status;
    }
}
