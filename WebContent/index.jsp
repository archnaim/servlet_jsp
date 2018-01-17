<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello <%= session.getAttribute( "username" ) %>
<%
	if(session.getAttribute("username") != null)
	{
		response.sendRedirect("commodity");
		
	}
	else
	{
		response.sendRedirect("login");
	}
%>
</body>
</html>