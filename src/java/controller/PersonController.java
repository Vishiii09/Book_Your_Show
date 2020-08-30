/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



import bean.Person;
import daos.PersonDao;
import com.utility.FileUploader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

 
public class PersonController extends HttpServlet {

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String op = request.getParameter("op");

        if (op != null && op.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            PersonDao pd = new PersonDao();
            if (pd.removeById(id)) {
                response.sendRedirect("view.jsp");
            }
        }

        if (op != null && op.equalsIgnoreCase("check_userid")) {
            String userid = request.getParameter("userid");
            PersonDao pd = new PersonDao();
            if (userid == null || userid.equals("")) {
                out.println("<font size='4'>Plase provide Userid</font>");
                return;
            }
            if (pd.isUseridExist(userid)) {
                out.println("<font color='red' size='4'>Sorry This Userid already Exist!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congrats! this userid is available!!</font>");
            }
        }

    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String op = request.getParameter("op");

        if (op != null && op.equalsIgnoreCase("add")) {
            System.out.println("Request Found......");

            try {
                //check the enctype of the incomming request -
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                String encodedPassword = "";
                String photo = "", imagePath = "";
                if (isMultipart)  
                    imagePath = FileUploader.getUploadedPath(getServletContext(), "media/person", request);
//JDBC Code 
                    PersonDao pd = new PersonDao();
                    HttpSession session = request.getSession();
                    Person person = (Person) session.getAttribute("person");
                    

                    encodedPassword = Base64.getEncoder().encodeToString(person.getPassword().getBytes("UTF-8"));
                    person.setPassword(encodedPassword);

                    if (pd.add(person)) {
                        session.removeAttribute("person");
                        response.sendRedirect("show.jsp");
                    }

              

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }

        }
        
        
        if (op != null && op.equalsIgnoreCase("update")) {
            System.out.println("Request Found......");

            try {
                //check the enctype of the incomming request -
              
                
//JDBC Code
                    PersonDao pd = new PersonDao();
                    HttpSession session = request.getSession();
                    Person person = (Person) session.getAttribute("person1");
                    System.out.println("Beans received Person1 " + person);
                   
                   // encodedPassword = Base64.getEncoder().encodeToString(person.getPassword().getBytes("UTF-8"));
                    //person.setPassword(encodedPassword);

             

                    if (pd.update(person)) {
                        session.removeAttribute("person1");
                        response.sendRedirect("view.jsp");
                    }

                

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }

        }

    }
}
