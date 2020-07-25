<%-- 
    Document   : viewpages
    Created on : 14 Jul, 2020, 9:20:36 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="base.jsp"></jsp:include>
    </head>
    <body>
    <center><h2>List of Movies</h2> </center>
    <table width='700' border='1' cellspacing='0' class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Operations</th>
        </tr>
        <%
            int start= request.getParameter("start")!=null? Integer.parseInt(request.getParameter("start")):0;
            int end=3;
            int total=0;
             try{
           //Register the Oracle Driver -
           Class.forName("com.mysql.jdbc.Driver");
           
           //Create Connection -
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow","root","");
           
           if (con!=null) 
           {
              PreparedStatement ps = con.prepareStatement("select count(*) from movie");
              ResultSet r = ps.executeQuery();
              if(r.next()){
                  total= r.getInt(1);
              }
               
              String sql = "select * from movie limit ?,?";
              PreparedStatement smt = con.prepareStatement(sql);
              smt.setInt(1, start);
              smt.setInt(2, end);
               
              ResultSet rs = smt.executeQuery(); 
              while(rs.next())
              {%>
              <tr>
                  <td><%=rs.getString("M_id")%> </td>
                  <td><%=rs.getString("M_name")%> </td>
                  
                  <td><a href="edit.jsp?id=<%=rs.getString("id")%>" class="btn btn-success"> <i class="fa fa-pencil" aria-hidden="true"></i></a>  |  <a href="First?id=<%=rs.getString("M_id")%>&op=delete" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></a> </td>
              </tr>
              
              <%}
              
               con.close();
           }
           
           
       
       }catch(Exception e){
           System.out.println("Error "+ e.getMessage());
       }
            %>
      </table>
    <br/>
    <span style="float:left"><a href="viewpages.jsp?start=<%=start-end%>" class="btn btn-primary <% if(start==0) out.println("disabled");%>">Previous</a></span>
    <center>
    <%
     
       for(int i=0; i<=total/end; i++)
       {%>
       <span style="text-decoration: none; align-content: center;  <% if(Math.floor(start/end) == i) out.println("background-color: orange");%>" class="btn btn-dark"><a href="show.jsp?start=<%=end*i%>">Page <%=i+1%> </a></span> 
       <%}
        %>
     <span style="float:right"><a href="viewpages.jsp?start=<%=start+end%>" class="btn btn-primary <% if(start+end >=total)out.println(" disabled");%> ">NEXT</a></span>
  
    </center> 
    <br/><br/>
    
    </body>
</html>
