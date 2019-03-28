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
		<a href="addMoney.jsp">Add Money</a>&nbsp;
		<a href="transfer.jsp">Transfer Money</a>&nbsp;
		<a href="checkBal.jsp">Check Balance</a>&nbsp;
	</div>
	<form action="./PaymentController?type=checkBal" method="post">
		<table align="center">
			<tr><td><input type="submit" value="Check Balance"/></td>
		</table>
	</form>
</body>
</html>