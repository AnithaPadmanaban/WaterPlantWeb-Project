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
<p>Can Order</p>
<script type="text/javascript">
function canOrder()
{
alert("Ordered Successfully");
window.location.href = "userView.jsp";
}
</script>
<form action="OrderCanServlet">
<label>Enter no of Can</label>
<input type="text" id="orderCanID" name="orderCanName"><br>
<input type="button" value="Cancel" class="btn btn-danger" onclick="window.location.href ='userView.jsp'">
<input type="submit" value="Submit"  class="btn btn-success">
</form>
</body>
</html>