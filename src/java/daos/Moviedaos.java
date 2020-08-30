/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import bean.Movie;
import jdbc.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Moviedaos {
    public boolean add(Movie movie, String[] c_ids) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        System.out.println("connection in addmovie"+con);
          
        if (con != null) {
            try {
                con.setAutoCommit(false);
                System.out.println("add movie stage 1");
                String sql = "Insert into movie(M_name, M_banner,M_Release_date, M_description, M_Release_out) values(?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, movie.getM_name());
                smt.setString(2, movie.getM_banner());
                smt.setString(3, movie.getM_Release_date());
                smt.setString(4, movie.getM_description());
                smt.setString(5,movie.getM_Release_out());

                int n= smt.executeUpdate();
                System.out.println("N after inserting movie"+n);
                sql = "select M_id from movie order by M_id desc limit 1";
                smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                int M_id = -1;
                if (rs.next()) {
                    M_id = rs.getInt("M_id");
                                   System.out.println("id"+M_id);
                    for (String c_id :c_ids) {
                        sql = "insert into mcr (M_id,c_id) values(?,?)";
      
                        smt = con.prepareStatement(sql);
                        smt.setInt(1, M_id);
                        smt.setInt(2, Integer.parseInt(c_id));
                        n=smt.executeUpdate();
                        System.out.println("N"+n);
                        
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
                System.out.println("Error in add dao" + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }
        return status;
    }
    public boolean removeById(int M_id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Delete from mcr where M_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, M_id);
                smt.executeUpdate();
                String sql1 = "Delete from movie where M_id=?";
                PreparedStatement smt1 = con.prepareStatement(sql1);
                smt1.setInt(1, M_id);
                smt1.executeUpdate();
                status = true;
                System.out.println("Movie Removed !!");
                smt.close();
                smt1.close();

            }

            cp.putConnection(con);

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public Movie getById(int M_id) {
        Movie movie = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from movie where M_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, M_id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    movie = new Movie();
                    movie.setM_id(rs.getInt("M_id"));
                    movie.setM_name(rs.getString("M_name"));
                    movie.setM_banner(rs.getString("M_banner"));
                    movie.setM_Release_date(rs.getString("M_Release_date"));
                    movie.setM_description(rs.getString("M_description"));
                    movie.setM_Release_out(rs.getString("M_Release_out"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return movie;
    }

    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> movieList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from movie";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                     Movie movie = new Movie();
                    movie.setM_id(rs.getInt("M_id"));
                    movie.setM_name(rs.getString("M_name"));
                    movie.setM_banner(rs.getString("M_banner"));
                    movie.setM_Release_date(rs.getString("M_Release_date"));
                    movie.setM_description(rs.getString("M_description"));
                    movie.setM_Release_out(rs.getString("M_Release_out"));

                    movieList.add(movie);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return movieList;
    }

    public ArrayList<Movie> getMovieByLimit(int start, int stop) {
        ArrayList<Movie> movieList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from movie limit ?, ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, stop);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Movie movie = new Movie();
                     movie = new Movie();
                    movie.setM_id(rs.getInt("M_id"));
                    movie.setM_name(rs.getString("M_name"));
                    movie.setM_banner(rs.getString("M_banner"));
                    movie.setM_Release_date(rs.getString("M_Release_date"));
                    movie.setM_description(rs.getString("M_description"));
                    movie.setM_Release_out(rs.getString("M_Release_out"));

                    movieList.add(movie);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return movieList;
    }

    public int getMoviesCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from movie";
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

    public ArrayList<Movie> getMoviesByC_id(int c_id) {
        ArrayList<Movie> movieList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from movie where M_id in (select M_id from mcr where c_id =?) order by M_id desc";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, c_id);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Movie movie = new Movie();
                     movie = new Movie();
                    movie.setM_id(rs.getInt("M_id"));
                    movie.setM_name(rs.getString("M_name"));
                    movie.setM_banner(rs.getString("M_banner"));
                    movie.setM_Release_date(rs.getString("M_Release_date"));
                    movie.setM_description(rs.getString("M_description"));
                    movie.setM_Release_out(rs.getString("M_Release_out"));

                    movieList.add(movie);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return movieList;
    }

    
    public static void main(String[] args) {
        System.out.println("hello");
    }

}
