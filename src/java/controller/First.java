/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Base64;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringEscapeUtils;

public class First extends HttpServlet {

      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        //out.println("<h1>This is first servlet , You are using GET Request</h1>");
        
        //delete then redirect
       String op = request.getParameter("op");
       
       if(op!=null && op.equalsIgnoreCase("delete")) 
       {
        try
       {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow","root","");
          String sql ="Delete from mcr where M_id=?";
          PreparedStatement smt = con.prepareStatement(sql);
          int id = Integer.parseInt(request.getParameter("id"));
          smt.setInt(1, id);
          int n = smt.executeUpdate();
          con.close();
        }catch(Exception e){
           System.out.println("error : "+ e.getMessage());
       }
        
        response.sendRedirect("dashboard.jsp");
       }
       
     
  if(op!=null && op.equalsIgnoreCase("logout"))
  {
      HttpSession session =request.getSession();
      session.invalidate();
      session=null;
      response.sendRedirect("error.jsp");
  }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       response.setContentType("text/html");
       request.setCharacterEncoding("UTF-8");
      
       String op=request.getParameter("op");
       
       if(op!=null && op.equalsIgnoreCase("add"))
       { 
       //Fetching the Form's DataE :
       String name=StringEscapeUtils.escapeHtml(request.getParameter("name"));
       String contact = request.getParameter("contact");
       String userid=request.getParameter("userid");
       String password=request.getParameter("password");
       //password hashing...
       String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes("UTF-8"));
        
       
       //jdbc:
       try
       {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow","root","");
          String sql ="insert into person(name,contact,userid,password)values(?,?,?,?)";  //parametrized query
          PreparedStatement smt = con.prepareStatement(sql);
          smt.setString(1, name);
          smt.setString(2, contact);
          smt.setString(3, userid);
          smt.setString(4,encodedPassword);
          
         int n = smt.executeUpdate();
        con.close();
         if(n>0)
             //out.println("<script>alert('Record Inserted');</script>");
             response.sendRedirect("main.jsp");
       
       }catch(Exception e){
           //if (e.getMessage().contains("Duplicate entry"))
             //  response.sendRedirect("index.jsp?error=UserId Already Registered!!");
           
            
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            out.println("<h2> <font color='red'>" + e.getMessage() +"</font></h2><hr/>") ;
            rd.include(request, response);
            
            
            System.out.println("error : "+ e.getMessage());
       }
       }
       
   if(op!=null && op.equalsIgnoreCase("update"))
       { 
       //Fetching the Form's Data :
       String name=request.getParameter("name");
       
       String contact = request.getParameter("contact");
       
       
       int id = Integer.parseInt(request.getParameter("id"));
       //jdbc:
       try
       {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow","root","");
          String sql ="update person set name=?,contact=? where id=?";
          PreparedStatement smt = con.prepareStatement(sql);
          smt.setString(1, name);
          smt.setString(2, contact);
          smt.setInt(3, id);
         int n = smt.executeUpdate();
        con.close();
         if(n>0)
             //out.println("<script>alert('Record Updated..');</script>");
             response.sendRedirect("home.jsp");
       
       }catch(Exception e){
           System.out.println("error : "+ e.getMessage());
       }
       } 
   
  if (op!=null && op.equalsIgnoreCase("login")){
      String userid=request.getParameter("userid");
      String password = request.getParameter("password");
      String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes("UTF-8"));
       Connection con=null;
       PreparedStatement smt = null;
       System.out.println("Hello.....");
     try{
        String sql = "select * from person where userid=? and password=?";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow","root","");
        smt = con.prepareStatement(sql);
        smt.setString(1, userid);
        smt.setString(2,encodedPassword);
        
       
        ResultSet rs= smt.executeQuery();
        if (rs.next()){
            HttpSession session = request.getSession();
            session.setAttribute("name", rs.getString("name"));
            session.setAttribute("userid",rs.getString("userid"));
            
            String remember = request.getParameter("remember");
            if (remember!=null && remember.equalsIgnoreCase("remember")){
                Cookie c = new Cookie("userid", userid);
                Cookie c2 = new Cookie("password", password);
                c.setMaxAge(60*60*24);
                c2.setMaxAge(60*60*24);
                response.addCookie(c);
                response.addCookie(c2);
            }
            response.sendRedirect("main.jsp");
        }
        else {
            response.sendRedirect("login.jsp?msg=Sorry!Invalid Userid or password");
        }
         
     }catch(Exception e){
         System.out.println("Error : "+ e.getMessage());
     }
     
     finally{
        try{
         con.close();
         smt.close();
        } catch(Exception e){}
                
     }
  }
  
       
        
}
 

}
