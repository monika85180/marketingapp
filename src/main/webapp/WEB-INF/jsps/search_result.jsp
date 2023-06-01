<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Search Result</h2>
<table border="1">
<tr><th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Mobile</th>
<th>Action</th>
</tr>

<c:forEach var="lead" items="${leads}"> 
<tr> 
<td>${lead.firstName}</td>
<td>${lead.lastName}</td>
<td>${lead.email}</td>
<td>${lead.mobile}</td> 
<td><a href="delete?email=${lead.email}">Delete</a></td>
<td><a href="update?email=${lead.email}">Update</a>
</tr>

</c:forEach>



</table>

</body>
</html>