<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img alt="">
<center>
<form action="RegUser"  method="post" >
<pre>
<h1>Sign Up</h1><h2><b>
<hr>
User Name:      <input type="text" name="uname"  required="required"><br>
Email Id:       <input type="email" name="email"  required="required"><br>
Password:       <input type="password" name="password"  required="required"><br>
your pet name:  <input type="text" name="question"  required="required"><br>

                 <input  type="submit" value="Sign Up"></b></h2>
                 <a href="UserLogin">Login</a>
<h4>${msg}</h4>
</pre>
</form>
</center>
</body>
</html>