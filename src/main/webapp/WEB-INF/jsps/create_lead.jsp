<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
<h2>Create Lead</h2>
<form action="saveLead" method="post">
<pre>

First Name<input type="text" name="firstName"/>
Last Name<input type="text"  name="lastName"/>
Email ID<input type="text" name="email"/>
Mobile<input type="text" name="mobile"/>

<input type="submit" value="save"/>
</pre>

${msg} 

</form>
</body>
</html>