<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Enter Number of can to be added in Database</h1>
<label>Enter No of Can</label><br>
<input type="text" id="adminCanID"><br>
<input type="button" class="btn btn-success" value="Add Stock" onclick="addStcok()">
</body>
</html>