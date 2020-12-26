<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%out.println("Login Successful! \n" +" Welcome!"); %>
	
	<a href="logout.jsp">Logout</a>
	
	<%session.invalidate(); %>

</body>
</html>