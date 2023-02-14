<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	

	<style>
		* {
			margin: 0;
			padding: 0;
		}
		
	
		
		
		
		.nav {
			width: 100vw;
			height: 40vh;
			background-color: #3944F7;
			font-size: x-large;
			color: white;
			text-align: center;
			margin: 10px 5px;
			display: flex;
			flex-direction: row;
			justify-content: space-around;
			place-items: center;
		}
		
		.btn {
			color: white;
			background-color: #38CC77;
			height: 40px;
			width: 90px;
			padding: 2px;
			border: 2px solid black;
			text-decoration: none;
		}
	</style>
</head>

<body>

	<div class="nav">
	<h2 > <marquee>Welcome to Basic CRUD Application</marquee> </h2>
		<a href="../Insert.html" class="btn" target="body">Insert</a>
		<a href="../Select.html" class="btn" target="body">Select</a>
		<a href="../delete.html" class="btn" target="body">Delete</a>
		<a href="../update.html" class="btn" target="body">Update</a>
	</div>
	<iframe name="body"
        style="width:100%;height:300px;">
       
        </iframe>
	
	
</body>

</html>
    