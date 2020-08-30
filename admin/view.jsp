<%-- 
    Document   : view
    Created on : 24 Jun, 2020, 9:35:51 PM
    Author     : HP
--%>

<%@page import="bean.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daos.Moviedaos"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Movie</title>
          <link rel="icon" type="image/ico" href="../assest/images/icon.ico" >
         <jsp:include page="base.jsp"></jsp:include>
    </head>
    <body>
        <%
     if(session.getAttribute("admin")==null){
         response.sendRedirect("../login.jsp");
         return;
    }
%>    
     
  <jsp:include page="nav.jsp"></jsp:include>
</br>
</br>
<div class="container-fluid">
                <div class="row">
                <jsp:include page="sidebar.jsp"></jsp:include>
               
               
               <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                   
       
     
     
        <table width="500" cellspacing="0" class=" table table-hover">
              <tr><th colspan="2"><center><h2> Delete Movie</h2></center></th></tr>
            <tr>
                 <th>ID</th>
                <th>title</th>
                <th>image</th>
                <th>Rdate</th>
                <th>Description</th>
                <th>Rout</th>
               <th>Operations</th>
               </tr>
           
               
               
               
                 <%-- JDbc fetching data from database and displaying on jsp page--%>
                <%
                     
               Moviedaos nd = new Moviedaos();
            ArrayList<Movie> rows =new ArrayList();
           
           
            rows = nd.getAllMovies();
            for(Movie movie : rows)
              {%>
                  <tr>
                    <td><%=movie.getM_id()%></td>
                     <td><%=movie.getM_name()%></td>
                     <td><%=movie.getM_banner()%></td>
                     <td><%=movie.getM_Release_date()%></td>
                     <td><%=movie.getM_description()%></td>
                     <td><%=movie.getM_Release_out()%></td>
                   
                      <td><a href="../MovieController?id=<%=movie.getM_id()%>&op=delete" class="btn btn-link"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
                </tr>
                   
                   <%}%>
               
        </table>
               
      </div> </main></div></div></div>    
    </body>
</html>
