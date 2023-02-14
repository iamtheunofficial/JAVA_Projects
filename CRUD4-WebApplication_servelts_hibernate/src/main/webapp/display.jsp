<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.model.Employee" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%Employee emp1=(Employee)request.getAttribute("emp"); 
    
    %>
  
    <jsp:useBean id="emp" class="com.model.Employee">
    
    </jsp:useBean>
   <jsp:setProperty property="id" name="emp" value="<%=emp1.getId() %>"/>
     <jsp:setProperty property="name" name="emp" value="<%=emp1.getName() %>"/>
       <jsp:setProperty property="age" name="emp" value="<%=emp1.getAge() %>"/>
         <jsp:setProperty property="address" name="emp" value="<%=emp1.getAddress() %>"/>
             <jsp:setProperty property="dob" name="emp" value="<%=emp1.getDob() %>"/>


<table border="1" align="center">
  <tr>
    <th>id</th>
    <th>Name</th>
     <th>Age</th>
      <th>Address</th>
       <th>DOB</th>
  </tr>
  <tr>
  <td> <jsp:getProperty property="id" name="emp"/></td>
  <td> <jsp:getProperty property="name" name="emp"/></td>
 <td>  <jsp:getProperty property="age" name="emp"/></td>
  <td> <jsp:getProperty property="address" name="emp"/></td>
    <td> <jsp:getProperty property="dob" name="emp"/></td>
  </tr>
</table>

    