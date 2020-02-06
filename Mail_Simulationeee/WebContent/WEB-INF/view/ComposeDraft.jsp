<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Edited Mail</h1>
<h3><center><table border='1'><tr><th>Draft Messages</th><th>Draft Emails</th><th>Edit</th></tr>
<c:forEach var="dto" items="${list}">
<tr>
<td><center> ${dto.getFromId() } </center></td>
<td><center> ${dto.getMessage() } </center></td></tr>

</c:forEach>
</center>


</body>
</html>