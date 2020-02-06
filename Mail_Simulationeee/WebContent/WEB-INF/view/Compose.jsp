<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Compose Mail</h1><h2><b>
<hr>
<form action="Sent"  method="post" >
<pre>
To           <input type="email" name="email"  required="required"><br>

subject      <input type="subject" name="subject"  required="required">

                  
  Message       <textarea rows="3" cols="25" name="message"  required="required"></textarea><br>

                         <input  type="submit" value="Sent"></b></h2>
         <h6>${msg}</h6>               
</pre>
</form>
</center>

</body>
</html>