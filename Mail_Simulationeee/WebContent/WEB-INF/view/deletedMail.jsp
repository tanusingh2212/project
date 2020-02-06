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
<h1>Deleted Mail</h1>
<h3><table border='1'><tr><th>MailId</th><th>Message</th></tr>
<c:forEach var="dto" items="${list}">
<tr>
<td><center> ${dto.getFromId() } </center></td>
<td><center> ${dto.getMessage() } </center></td></tr>
$(msg)
</c:forEach>
</center>
</body>
</html>