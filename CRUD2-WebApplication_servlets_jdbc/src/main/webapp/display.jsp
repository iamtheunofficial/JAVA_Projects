<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Student details</h2>
<table border="1" >
<tr>
<th>Id</th>
<th>${requestScope.std1.id}</th>
</tr>
<tr>
<th>Name</th>
<th>${requestScope.std1.name}</th>
</tr>
<tr>
<th>Age</th>
<th>${requestScope.std1.age}</th>
</tr>
<tr>
<th>Address</th>
<th>${requestScope.std1.address}</th>
</tr>
<tr>
<th>Gender</th>
<th>${requestScope.std1.gender}</th>
</tr>
</table>
</body>
</html>