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
<h1><br><a href="logout">logout</a>|<a href="Compose">Compose</a>|<a href="SentInbox">SendInbox</a>|<a href="Inbox">Inbox</a><br></h1>
<center><h1>Sent Emails</h1></center>
<hr>
<h3><center><table border='1'><tr><th>Email ID</th><th>Messages</th><th>action</th></tr>
<c:forEach var="idto" items="${plist}">
<tr><td><center>${idto.getToid() }</center></td>
<td><center>${idto.getMessage() }</center></td>
<td><center><a href="delete?msgid=+${idto.getMsgid()}+">delete</a></center></td></tr>
</c:forEach>
</table>

</body>
</html>