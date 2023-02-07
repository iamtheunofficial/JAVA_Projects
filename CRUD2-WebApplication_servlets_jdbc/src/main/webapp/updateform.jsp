<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./e"><h2>Student details</h2>

<table border="1" >
<tr>
<th>Id</th>
<th><input type="text" name="uid" value="${requestScope.std1.id}" readonly="readonly">  </th>
</tr>
<tr>
<th>Name</th>
<th> <input type="text" name="uname" > </th>
</tr>
<tr>
<th>Age</th>
<th><input type="text" name="uage"></th>
</tr>
<tr>
<th>Address</th>
<th><input type="text" name="uaddress"></th>
</tr>
<tr>
<th>Gender</th>
<th><input type="text" name="ugender"></th>
</tr>
<tr>

<th><input type="submit" name="Update"></th>
</tr>
</table>
</form>
</body>
</html>