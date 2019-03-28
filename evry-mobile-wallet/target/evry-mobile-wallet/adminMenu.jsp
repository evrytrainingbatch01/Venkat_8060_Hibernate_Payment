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
		<form action="./PaymentController?type=adminlogin" method="post">
		<table align="center">
			<tr><th>Add Money: </th><td><input type="text" name="money" /></td></tr>
			<tr><th>Transfer Money: </th><td><input type="text" name="tran"/></td></tr>
			<tr><th>Check Balance: </th><td><input type="text" name="bal"/></td></tr>
			<tr><td><input type="submit" value="Submit"/></td>
			<td><input type="reset" value="Reset"/></td></tr>
		</table>
	</form>
</body>
</html>