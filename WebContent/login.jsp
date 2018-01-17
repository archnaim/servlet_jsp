<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/login.css" />
<title>Login Page</title>
</head>
<body>
	<div class="container">

      <form class="form-signin" action="login" method="post" id="form_login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" name="uname" class="form-control" placeholder="Email address" required="" autofocus="" autocomplete="off">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="psw" class="form-control" placeholder="Password" required="" autocomplete="off">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div>
</body>
</html>