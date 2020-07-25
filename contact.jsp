<%-- 
    Document   : contact
    Created on : 24 Jun, 2020, 8:56:30 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<jsp:include page="base.jsp"></jsp:include>
    <!DOCTYPE html>
    <html lang="en">

        <head>

            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="">
            <meta name="author" content="">

            <title>Contact us </title>

            <!-- Bootstrap core CSS -->
            <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

            <!-- Custom styles for this template -->
            <link href="assets/css/shop-homepage.css" rel="stylesheet">

            <style>
                body{
    background: -webkit-linear-gradient(left, #0072ff, #00c6ff);
}
.contact-form{
    background: #fff;
    margin-top: 10%;
    margin-bottom: 5%;
    width: 70%;
}
.contact-form .form-control{
    border-radius:1rem;
}
.contact-image{
    text-align: center;
}
.contact-image img{
    border-radius: 6rem;
    width: 11%;
    margin-top: -3%;
    transform: rotate(29deg);
}
.contact-form form{
    padding: 14%;
}
.contact-form form .row{
    margin-bottom: -7%;
}
.contact-form h3{
    margin-bottom: 8%;
    margin-top: -10%;
    text-align: center;
    color: #0062cc;
}
.contact-form .btnContact {
    width: 50%;
    border: none;
    border-radius: 1rem;
    padding: 1.5%;
    background: #dc3545;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
}
.btnContactSubmit
{
    width: 50%;
    border-radius: 1rem;
    padding: 1.5%;
    color: #fff;
    background-color: #0062cc;
    border: none;
    cursor: pointer;
}
            </style>
        </head>

        <body>

            <!-- Navigation -->
        <jsp:include page="nav.jsp"></jsp:include>

            <!-- Page Content -->
                                    
<div class="container contact-form">
            <div class="contact-image">
                <img src="assests/images/rocket.png" alt="rocket_contact"/>
            </div>
            <form method="post">
                <h3>Drop Us a Message</h3>
               <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" name="name" class="form-control" placeholder="Your Name *" value="" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="text" name="email" class="form-control" placeholder="Your Email *" value=""  required="required"/>
                        </div>
                        <div class="form-group">
                            <input type="text" name="contact" class="form-control" placeholder="Your Phone Number *" value="" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="submit" name="btnSubmit" class="btnContact" value="Send Message"  />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <textarea name="message" class="form-control" placeholder="Your Message *" style="width: 100%; height: 150px;" required="required"></textarea>
                        </div>
                    </div>
                </div>
            </form>
</div>          
            <!-- /.row -->

        </div>
        <!-- /.container -->

 <footer>
       <!-- Footer Start-->
       
        <!-- Footer End-->
    </footer>
   
	
        <!-- Bootstrap core JavaScript -->
        <script src="assests/jquery/jquery.min.js"></script>
        <script src="assests/js/bootstrap.bundle.min.js"></script>

    </body>

    
    <%
        if(request.getParameter("btnSubmit")!=null ){
            Connection con=null;
            PreparedStatement smt=null;
    %>
        <jsp:useBean id="query" class="bean.Query" scope="page"></jsp:useBean>
        <jsp:setProperty name="query" property="*"></jsp:setProperty>
       
        <%
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow","root","");
            String sql = "Insert into query (name,email,contact,message) values(?,?,?,?)";
            smt = con.prepareStatement(sql);
            smt.setString(1, query.getName());
            smt.setString(2, query.getEmail());
            smt.setString(3, query.getContact());
            smt.setString(4, query.getMessage());
            
            int n =smt.executeUpdate();
            con.close();
            smt.close();
            if (n>0)
                out.println("<script> alert('We will Soon give you update ');</script>");
        }
        catch(Exception e){
            System.out.println("Error : "+ e.getMessage());
        }
        } %>
</html>

