<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="Login"  method="post" >
<pre>
<h1>Login </h1><h2><b>
<hr>
Email Id:  <input type="email" name="email"  required="required"><br>
Password:  <input type="password" name="password"  required="required"><br>
           <input  type="submit" value="Login"></b></h2>
           <a href="forgotPassword">forgotPassword</a>|<a href="UserRegister">Register</a><br><br>
           
<h4>${msg}</h4>

</pre>
</form>
</center>
</body>
</html>