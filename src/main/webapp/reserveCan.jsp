<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Reserve Can</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<p>Can Reservation</p>
<script type="text/javascript">
function canReserve()
{
alert("Reserved Successfully");
window.location.href = "userView.jsp";
}
</script>
<form action="ReserveCanServlet">
<label>Enter no of Can</label>
<input type="text" id="reserveCanID" name="reserveCanName"><br>
<input type="button" value="Cancel" class="btn btn-danger" onclick="window.location.href ='userView.jsp';">
<input type="submit" value="Submit"  class="btn btn-success" onclick="window.location.href ='userView.jsp';">
</form>
</body>
</html>