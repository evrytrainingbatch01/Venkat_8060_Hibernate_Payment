<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evry Payment Wallet</title>
</head>
<body style="background-color:powderblue;">
	<div align="center">
		<h1 align="center">Evry Payment Wallet</h1>
		<a href="index.jsp">Home</a>&nbsp;
		<a href="adminlogin.jsp">Admin Login</a>&nbsp;
		<a href="userlogin.jsp">User Login</a>&nbsp;
		<a href="signup.jsp">Signup</a>&nbsp;
	</div>
	<form action="./PaymentController?type=adminlogin" method="post">
		<table align="center">
			<tr><th>Admin Name: </th><td><input type="text" name="fname" /></td></tr>
			<tr><th>Password: </th><td><input type="password" name="pwd"/></td></tr>
			<tr><td><input type="submit" value="Login"/></td>
			<td><input type="reset" value="Reset"/></td></tr>
		</table>
	</form>
</body>
</html>