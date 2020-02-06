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


<center><h1>Inbox</h1></center>
<hr>
<h3><center><table border='1'><tr><th>Send By</th><th>Messages</th><th>Action</th></tr>
<c:forEach var="idto" items="${plist}">
<tr><td><center>${idto.getFromid()}</center></td>
<td><center>${idto.getMessage() } </center></td>
<td><center><a href="delete?msgid=+${idto.getMsgid()}+">delete</a></center></td></tr>

</c:forEach>
</table>
<h6>${msg}</h6>

</body>
</html>




