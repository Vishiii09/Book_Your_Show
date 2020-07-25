<%@page import="daos.Moviedaos"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daos.Categorydaos"%>
<%@page  import="java.sql.*" %>
<div class="col-lg-3">

        <h1 class="col-md-4">Category</h1>
        <div class="list-group" >
            <a href="main.jsp" class="list-group-item <%if(request.getParameter("c_id")==null) out.println(" active ");%>"> Movies </a>   <br/>
                   
            <% 
               Categorydaos ncd  =new Categorydaos();
                Moviedaos nd = new Moviedaos();
                ArrayList<Category> categorylist  = ncd.getAllMovieCategory(); 
    for (Category category : categorylist) {%>
    <a href="main.jsp?c_id=<%=category.getId()%>" class="list-group-item <%if(String.valueOf(category.getId()).equals(String.valueOf(request.getParameter("c_id")))) out.println(" active ");%>"> <%=category.getC_name()%> </a>   <br/>
                        <%}%>
     
               </div>
</div>