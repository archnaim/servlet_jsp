<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-homepage.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Hello <%=session.getAttribute("username") %></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="/servlet_jsp/commodity" >Home
              </a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="#">Report
              <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/servlet_jsp/logout" id="logout" style="color:red">LogOut</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-12">

          <h1 class="my-4">Report</h1>
          <table class="table">
    <thead>
      <tr>
        <th>No</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Product Type</th>
        <th>Amount</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <%
int var=0;
%>

<c:forEach items="${carts}" var="cart">
<%
var++;
%>

      <tr>
        <td><%=var%></td>
        <td>${cart.product.productName}</td>
        <td>${cart.product.price}</td>
        <td>${cart.product.type}</td>
        <td>${cart.amount}</td>
        <td>
        <form method="post" id="/report" >
        <input type="hidden" name="cart_id" value="${cart.id}">
        <button type="submit" class="btn btn-danger">Delete</button>
        </form>
        
        </td>
      </tr>
</c:forEach>
    </tbody>
  </table>

        </div>
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Mitrais 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
