<%@page import="com.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%Employee e=(Employee)request.getAttribute("emp"); 
    
    %>
    
  <h2 align="center">update Student details</h2>

<form action="./updateform" method="get" >
<table border="1" align="center">
<tr>
<th>Id</th>
<td> <input type="text" name="uid" value="<%=e.getId() %>" readonly="readonly">  </td>
</tr>
<tr>
<th>Enter Name</th>
<td> <input type="text" name="uname" required value="<%=e.getName() %>">  </td>
</tr>
<tr>
<th>Enter Age</th>
<td> <input type="number" name="uage" required value="<%=e.getAge() %>">  </td>
</tr>
<tr>
<th>Enter Address</th>
<td> <input type="text" name="uaddress" required value="<%=e.getAddress() %>">   </td>
</tr>
<tr>
<th>Enter DOB(dd-MM-YYYY)</th>
<td> <input type="date" name="dob" required value="<%=e.getDob() %>">  </td>
</tr>
<tr>

<td> <input type="submit" value="update-details" >  </td>
</tr>

</table>
</form>

</body>
</html>

    