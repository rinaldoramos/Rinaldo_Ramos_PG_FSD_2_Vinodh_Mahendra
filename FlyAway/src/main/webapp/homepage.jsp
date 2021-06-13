<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>FlyAway your best flying solution</title>
</head>
<body>

	<table align="center">
		<tr>
			<td><img src="plane.jpg" alt="FlyAway Logo" align="left" width="200" height="200"/></td>
			<td><h1 align="left" >Welcome to FlyAway</h1></td>
		</tr>
	</table>
	
	<h3 align="center">Your best solution to fly with style, comfort, and unbeatable prices </h3>
	
	<hr /><br/><br/>
	
	<form action="/FlyAway/SelectionServlet" method="post">
		<table border="2" align="center" width="260"> 
			<tr>
				<td>Username</td>
				<td><input type="text" name="user" placeholder="Enter email" style="width:95%"></input></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" placeholder="Enter password" style="width:95%"></input></td>
			</tr>
			<tr>
				<td><input type="submit" value="Log in" style="width:100%"></input></td>
				<td><a href="sign-in-form.html"><input type="button" value="Sign in" style="width:37%"></input></a> <a href="guest-selection.html"><input type="button" value="As a guest" style="width:60%"></input></a></td>								
			</tr>
		</table>
	</form>
</body>
</html>