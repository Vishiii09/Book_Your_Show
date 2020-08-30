/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import bean.Category;
import jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class Categorydaos {
    public boolean add(Category category) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "Insert into category(c_name) values(?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, category.getC_name());
                smt.executeUpdate();

                status = true;
                cp.putConnection(con);
                smt.close();

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
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
                String sql = "Delete from category where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Category Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    
    public Category getById(int id) {
        Category category = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from category where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setC_name(rs.getString("c_name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return category;
    }
    
    public ArrayList<Category> getAllMovieCategory() {
        ArrayList<Category> movieCategoryList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from category";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Category movieCategory = new Category();
                    movieCategory.setId(rs.getInt("id"));
                    movieCategory.setC_name(rs.getString("c_name"));
                    movieCategoryList.add(movieCategory);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return movieCategoryList;
    }

    public ArrayList<Category> getMovieCategoryByLimit(int start, int stop) {
        ArrayList<Category> categoryList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from category limit ?, ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, stop);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setC_name(rs.getString("c_name"));
                    categoryList.add(category);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return categoryList;
    }

    public int getMovieCategoryCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from category";
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

    public boolean update(Category category) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "update category set name=?  where id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, category.getC_name());
                smt.setInt(2, category.getId());
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                }
                smt.close();

            } catch (Exception e) {

                System.out.println("Error " + e.getMessage());
            }

        }

        return status;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
