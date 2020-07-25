<%-- 
    Document   : book
    Created on : 14 Jul, 2020, 12:29:54 PM
    Author     : HP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>about jsp page</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
		<link rel="shortcut icon" type="image/x-icon" href="assests/img/favicon.ico">

		<!-- CSS here -->
            <link rel="stylesheet" href="assests/css/bootstrap.min.css">
            <link rel="stylesheet" href="assests/css/owl.carousel.min.css">
            <link rel="stylesheet" href="assests/css/gijgo.css">
            <link rel="stylesheet" href="assests/css/slicknav.css">
            <link rel="stylesheet" href="assests/css/animate.min.css">
            <link rel="stylesheet" href="assests/css/magnific-popup.css">
            <link rel="stylesheet" href="assests/css/fontawesome-all.min.css">
            <link rel="stylesheet" href="assests/css/themify-icons.css">
            <link rel="stylesheet" href="assests/css/slick.css">
            <link rel="stylesheet" href="assests/css/nice-select.css">
            <link rel="stylesheet" href="assests/css/style.css">
            <link rel="stylesheet" href="assests/css/responsive.css">
   </head>

   <body>
   <jsp:include page="nav.jsp"></jsp:include>
</br>
</br>
</br>
</br>
    <HTML>


<BODY bgcolor="white">


<FORM TYPE=POST ACTION=seatcategory.jsp>
<BR>
<font size=5 color="red">
<center>
<h1>select time </h1><br>

<input TYPE=checkbox name=time VALUE=09:00 AM> 09:00 AM  <BR>
<input TYPE=checkbox name=time VALUE=12:00 PM> 12:00 PM  <BR>
<input TYPE=checkbox name=time VALUE=03:00 PM> 03:00 PM  <BR>
<input TYPE=checkbox name=time VALUE=06:00 PM> 06:00 PM  <BR>


<br> <INPUT TYPE="submit" name="submit" Value="Submit" id ="submit" class="btn btn-primary"/>
</center>
</font>
</FORM>
</BODY>
</HTML>
</br>
</br>
</br>
</br>
    
   <footer>
       <!-- Footer Start-->
       <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End-->
    </footer>
   
	<!-- JS here -->
	
		<!-- All JS Custom Plugins Link Here here -->
        <script src="assests/js/vendor/modernizr-3.5.0.min.js"></script>
		<!-- Jquery, Popper, Bootstrap -->
		<script src="assests/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="assests/js/popper.min.js"></script>
        <script src="assests/js/bootstrap.min.js"></script>
	    <!-- Jquery Mobile Menu -->
        <script src="assests/js/jquery.slicknav.min.js"></script>

		<!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="assests/js/owl.carousel.min.js"></script>
        <script src="assests/js/slick.min.js"></script>
        <!-- Date Picker -->
        <script src="assests/js/gijgo.min.js"></script>
		<!-- One Page, Animated-HeadLin -->
        <script src="assests/js/wow.min.js"></script>
		<script src="assests/js/animated.headline.js"></script>
        <script src="assests/js/jquery.magnific-popup.js"></script>

		<!-- Scrollup, nice-select, sticky -->
        <script src="assests/js/jquery.scrollUp.min.js"></script>
        <script src="assests/js/jquery.nice-select.min.js"></script>
		<script src="assests/js/jquery.sticky.js"></script>
               
        <!-- counter , waypoint -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script>
        <script src="assests/js/jquery.counterup.min.js"></script>

        <!-- contact js -->
        <script src="assests/js/contact.js"></script>
        <script src="assests/js/jquery.form.js"></script>
        <script src="assests/js/jquery.validate.min.js"></script>
        <script src="assests/js/mail-script.js"></script>
        <script src="assests/js/jquery.ajaxchimp.min.js"></script>
        
		<!-- Jquery Plugins, main Jquery -->	
        <script src="assests/js/plugins.js"></script>
        <script src="assests/js/main.js"></script>
        
    </body>
</html>






