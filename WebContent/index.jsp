<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Authentication</title>
</head>
<body>




	<h1>User Login Form</h1>


	<form action="LoginServ" method="post">
		<table>
		
		   <tr>
		    <td></td>
		    <td> <small style="color:green;">
		    
		      <%
		         String message = (String)request.getAttribute("message");
		       if(message != null){
		    	 }else{
		    		 message = "";
		    	 }
		      %>
		      
		      <%=message%>

		    </small> </td>
		   </tr>

			<tr>
				<td>Username</td>
				<td><input name="username" type="text" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input name="password" type="text" /></td>
			</tr>


			<tr>
				<td></td>
				<td><input type="submit" value="Sign In"/></td>
			</tr>


			<tr>

				<td></td>

				<td><br> 
				<a href="register.jsp">Not a User ? Register
							Now</a></td>

			</tr>



		</table>




	</form>











</body>
</html>