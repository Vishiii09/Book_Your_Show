<%-- 
    Document   : addMovie
    Created on : 22 Jun, 2020, 1:41:23 PM
    Author     : HP
--%>
<%@page import="daos.Categorydaos"%>
<%@page import="bean.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="bean.Movie,bean.admin,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Add Movie </title>
        <jsp:include page="base.jsp"></jsp:include>

            <script>

                function readURL(input, preview) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            preview.src = e.target.result;
                        };

                        reader.readAsDataURL(input.files[0]);
                    }
                }
            </script>
        <style>
                .bd-placeholder-img {
                    font-size: 1.125rem;
                    text-anchor: middle;
                    -webkit-user-select: none;
                    -moz-user-select: none;
                    -ms-user-select: none;
                    user-select: none;
                }

                @media (min-width: 768px) {
                    .bd-placeholder-img-lg {
                        font-size: 3.5rem;
                    }
                }
            </style>
      
    </head>
        <body>
        <%
            if (session.getAttribute("admin") == null) {
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
                        <jsp:useBean class="bean.admin" id="admin" scope="session"></jsp:useBean>
                        <jsp:useBean class="bean.Movie" id="movie" scope="session"></jsp:useBean>
                            <center>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-3" style="position: fixed;right:0px;">
                                        <%if (request.getParameter("submit") != null) {
                                                String c_id[] = request.getParameterValues("category");
                                                session.setAttribute("c_id", c_id);
                                        %>
                                        <jsp:setProperty name="movie" property="*"></jsp:setProperty>
                                            <form action="../MovieController?op=add" method="post" enctype="multipart/form-data">
                                                <img src="" style="width:200px; height: 200px;" id="preview" class="form-control"/> <br/>
                                                <input type="file" name="image" onchange="readURL(this, preview);" class="form-control btn btn-success"/> <br/>
                                                <input type="submit" value="Save to Data base " class="btn btn-primary" name="submit"/>
                                            </form>
                                        <%
                        }%>
                                    </div>



                                    <div class="col col-md-9">
                                        <form method="post" class="form">
                                            <table class="table">
                                                <tr><th colspan="2"><center><h2>Add Movie Here </h2></center></th></tr>
                                                <tr>
                                                    <td>Enter Movie Name </td>
                                                    <td><input type="text" name="m_name" class="form-control" value="${movie.m_name}"/></td>
                                                </tr> 
                                               
                                                <tr>
                                                <td>Release date:</td>
                                                <td><input type="date" id="Release date" name="m_Release_date" class="form-control" value="${movie.m_Release_date}"/></td>
                             
                                                    </tr>
                                                <tr>
                                                    <td>Enter Description </td>
                                                    <td><textarea name="m_description" rows="10" cols="20" class="form-control">
                                                            ${movie.m_description}
                                                        </textarea> 
                                                    </td>
                                                </tr> 
                                                
                                                 <tr>
                                                    <td>Select Categories for Movie </td>
                                                    <td>
                                                        <%
                                                            Categorydaos cd = new Categorydaos();
                                                            ArrayList<Category> categories = cd.getAllMovieCategory();
                                                            for (Category cat : categories) {%> 
                                                        <input type="checkbox" name="category" value="<%=cat.getId()%>" /> <%=cat.getC_name()%> 
                                                        <%}%>
                                                    </td>
                                                </tr>
                                                <tr>
                                                <td>Release out:</td>
                                                <td><input type="date" id="Release out" name="m_Release_out" class="form-control" value="${movie.m_Release_out}"/></td>
                             
                                                    </tr>
                                            </table>
                                            <input type="submit" value="save and Next" name="submit" id ="submit" class="form-control btn btn-primary"/>
                                        </form>
                                    </div>


                                </div>
                            </div>
                        </center>




                    </div>
                </main>
            </div>
        </main>
    </div>
</div>

</body>
</html>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    