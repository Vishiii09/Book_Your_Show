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
import bean.Movie;
import daos.Moviedaos;
import com.utility.FileUploader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpSession;
public class MovieController extends HttpServlet {

    
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
           int id= Integer.parseInt(request.getParameter("id"));
            Moviedaos nd = new Moviedaos();
            System.out.println("id :"+ id);
            if(nd.removeById(id))
            {
                System.out.println("Data Removed...");
                response.sendRedirect(request.getHeader("referer"));}
                
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
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        String op = request.getParameter("op");
        if(op!=null && op.equalsIgnoreCase("add")){
            HttpSession session = request.getSession();
            Movie movie = (Movie)session.getAttribute("movie");
            String catids[] = (String[]) session.getAttribute("c_id");
            Moviedaos nd = new Moviedaos();
            String imagePath ="";
            imagePath = FileUploader.getUploadedPath(getServletContext(), "media/movie", request);
            movie.setM_banner(imagePath);
            if(nd.add(movie, catids)){
                session.removeAttribute("movie");
                session.removeAttribute("c_id");
                out.println("Movie added Successfully !!");
            }
        }
    }

   

}
