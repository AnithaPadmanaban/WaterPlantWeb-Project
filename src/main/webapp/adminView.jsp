<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<script type="text/javascript">
function addStcok()
{
alert("Added Successfully in DB");
window.location.href = "index.jsp";
}
</script>
<h1>Enter Number of can to be added in Database</h1>
<label>Enter No of Can</label><br>
<input type="text" id="adminCanID"><br>
<input type="button" class="btn btn-success" value="Add Stock" onclick="addStcok()">
</body>
</html>