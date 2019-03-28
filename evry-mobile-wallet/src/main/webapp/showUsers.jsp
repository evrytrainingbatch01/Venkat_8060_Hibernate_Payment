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
		<h1 align="center">Evry Payment Wallet</h1>
		<a href="approveMoney.jsp">Add Money</a>&nbsp;
		<a href="sendMoney.jsp">Send Money</a>&nbsp;
		<a href="showUsers.jsp">Show Users</a>&nbsp;
	</div>
	<form action="./PaymentController?type=users" method="post">
		<table align="center">
			<tr><td><input type="submit" value="Show Users"/></td>
		</table>
	</form>
</body>
</html>