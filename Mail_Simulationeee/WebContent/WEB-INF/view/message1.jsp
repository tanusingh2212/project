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
<h1>Message</h1>
<div align="center">
<a href="inbox">Inbox</a>
<a href="sent">Sent</a>
<a href="draft">Draft</a>
<a href="compose">Compose</a>
<a href="change">ChangePassword</a>
<a href="deleteMail">DeletedMail</a>
<a href="logout">LogOut</a>
</div>
<hr>
<h3><table border='1'><tr><th>From Mail Id</th><th>TO Mail Id</th><th>Message</th></tr>
<c:forEach var="dto" items="${list}">
<tr><td><center>${dto.getFromId() }</center></td><td><center>${dto.getToId() }</center></td><td><center> ${dto.getMessage() } </center></td></tr><br>
</c:forEach>
<br><br>
</table>
</center>
</body>
</html>