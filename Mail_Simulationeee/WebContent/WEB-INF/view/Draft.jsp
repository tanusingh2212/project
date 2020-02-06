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
<center><h1>Draft Mails</h1></center>
<hr>

<h3><center><table border='1'><tr><th>Draft Messages</th><th>Draft Emails</th><th>action</th>Edit</th></tr>
<c:forEach var="idto" items="${plist}">
<tr><td><center>${idto.getDraft()}</center></td>
<td><center>${idto.getToid() }</center></td>
<td><center><a href="delete?msgid=+${idto.getMsgid()}+">delete</a></center></td></tr>
<td><center><a href="delete?msgid=+${idto.getMsgid()}+">edit</a></center></td></tr>

</c:forEach>
</table>
</body>
</html> 