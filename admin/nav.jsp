<!-- Navigation -->
 <!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assests/img/logo/loder-logo.png" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Search Movie </a>
        <ul class="navbar-nav ml-auto">
            <li>
            <input type="text" id="keyword" class="form-control" placeholder="Enter Keyword "/>
            </li>
              <i class="fa fa-search btn btn-success"id="search"></i>
             </ul>
          
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item <% if(request.getRequestURI().contains("main.jsp"))out.println(" active "); %>">
              <a class="nav-link" href="main.jsp"> <i class="fa fa-home"></i> Home</a>
          </li>
          <li class="nav-item  <% if(request.getRequestURI().contains("about.jsp"))out.println(" active "); %>">
              <a class="nav-link" href="about.jsp"><i class="fa fa-vcard"></i> About</a>
          </li>
          <li class="nav-item <% if(request.getRequestURI().contains("services.jsp"))out.println(" active "); %>">
              <a class="nav-link" href="services.jsp"> <i class="fa fa-server"></i> Services</a>
          </li>
          <li class="nav-item <% if(request.getRequestURI().contains("contact.jsp"))out.println(" active "); %>">
              <a class="nav-link" href="contact.jsp"><i class="fa fa-map-marker"></i> Contact</a>
          </li>
          <li class="nav-item <% if(request.getRequestURI().contains("login.jsp"))out.println(" active "); %>">
              <a class="nav-link" href="login.jsp"><i class="fa fa-user"></i> login</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
