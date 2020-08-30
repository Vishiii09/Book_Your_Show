/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import bean.admin;
import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 
public class AdminDao {
     public admin getByLoginDetail(String userid, String password) {
        admin admin = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from admin where userid=? and password = ?";
                PreparedStatement smt = con.prepareStatement(sql);
               smt.setString(1, userid);
               smt.setString(2,password);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    System.out.println("ok..");
                    admin = new admin();
                    admin.setImage(rs.getString("image"));
                    admin.setName(rs.getString("name"));
                  //  admin.setUserid(rs.getString("userid"));
                //   admin.setPassword(rs.getString("password"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return admin;
    }
}
