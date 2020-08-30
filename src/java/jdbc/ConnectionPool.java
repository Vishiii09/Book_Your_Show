
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.*;
import java.util.*;
/**
 *
 * @author HP
 */
public class ConnectionPool {
    static final int MAX_CONNECTIONS = 20;
    static Vector connections = null;
    static ConnectionPool instance = null;
    public synchronized void removeAllConnections(){
        try{
            if(connections == null){
                return;
            }
            int sz = connections.size();
            for(int i=0; i<sz;i++){
                Connection c = (Connection) connections.elementAt(i);
                c.close();
            }
            connections.removeAllElements();
            connections = null;
        }
        catch (SQLException sqlE) {
            System.out.println(sqlE);
        }

}
    public static synchronized ConnectionPool getInstance(){
        if (instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }
    
    public synchronized void initialize(){
        if (connections == null){
            try{
                String userName = "root";
                String Password = "";
                
                String url = "jdbc:mysql://localhost:3306/bookmyshow";
                
                Class.forName("com.mysql.jdbc.Driver");
                
                connections = new Vector();
                int count = 0;
                while(count < MAX_CONNECTIONS) {
                    Connection c = DriverManager.getConnection(url,userName,Password);
                    connections.addElement(c);
                    count++;
                }
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
            //System.out.println("over");
        }
    }
    public synchronized Connection getConnection(){
        Connection c = null;
        if(connections == null){
            return null;
        }
        if (connections.size()>0){
            c = (Connection) connections.elementAt(0);
            connections.removeElementAt(0);
        }
        return c;
    }
    
    public synchronized void putConnection(Connection c){
        connections.addElement(c);
        notifyAll();
    }
}

