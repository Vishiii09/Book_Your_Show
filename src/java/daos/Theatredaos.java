/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import bean.Theatre;
import jdbc.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Theatredaos {
    public boolean add(Theatre theatre, String[] M_ids) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                con.setAutoCommit(false);

                String sql = "Insert into movie(T_name,No_of_shows) values(?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, theatre.getT_name());
                smt.setString(2, theatre.getNo_of_shows());
                
                smt.executeUpdate();

                sql = "select T_id from movie order by T_id desc limit 1";
                smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                int T_id = -1;
                if (rs.next()) {
                    T_id = rs.getInt("id");

                    for (String M_id : M_ids) {
                        sql = "insert into Theatre (T_id,M_id) values(?,?)";
                        smt = con.prepareStatement(sql);
                        smt.setInt(1, T_id);
                        smt.setInt(2, Integer.parseInt(M_id));
                        smt.executeUpdate();
                    }
                }
                con.commit();
                status = true;
                smt.close();

            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception ex) {
                    System.out.println("Rollback error");
                }
                System.out.println("Error " + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
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
                String sql = "Delete from Theatre where T_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                smt.executeUpdate();
                String sql1 = "Delete from Booking where id=?";
                PreparedStatement smt1 = con.prepareStatement(sql1);
                smt1.setInt(1, id);
                smt1.executeUpdate();
                status = true;
                System.out.println("Theatre Removed !!");
                smt.close();
                smt1.close();

            }

            cp.putConnection(con);

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public Theatre getById(int id) {
        Theatre theatre = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from Theatre where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    theatre = new Theatre();
                    theatre.setT_id(rs.getInt("T_id"));
                    theatre.setT_name(rs.getString("T_name"));
                   
                    
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return theatre;
    }

    public ArrayList<Theatre> getAllTheatres() {
        ArrayList<Theatre> theatreList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from Theatre";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                     Theatre theatre = new Theatre();
                    theatre.setT_id(rs.getInt("T_id"));
                    theatre.setT_name(rs.getString("T_name"));
                   
                    theatreList.add(theatre);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return theatreList;
    }

    public ArrayList<Theatre> getTheatreByLimit(int start, int stop) {
        ArrayList<Theatre> theatreList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from Theatre limit ?, ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, stop);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Theatre theatre = new Theatre();
                     theatre = new Theatre();
                   theatre.setT_id(rs.getInt("T_id"));
                    theatre.setT_name(rs.getString("T_name"));
                   

                    theatreList.add(theatre);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return theatreList;
    }

    public int getTheatreCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from Theatre";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return total;

    }

    public ArrayList<Theatre> getTheatresByM_id(int M_ids) {
        ArrayList<Theatre> theatreList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from Theatre where id in (select T_id from Theatre where M_id =?) order by id desc";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, M_ids);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Theatre theatre = new Theatre();
                    theatre = new Theatre();
                   theatre.setT_id(rs.getInt("T_id"));
                    theatre.setT_name(rs.getString("T_name"));
                    

                    theatreList.add(theatre);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return theatreList;
    }

    
    public static void main(String[] args) {
        System.out.println("hello");
    }

}
