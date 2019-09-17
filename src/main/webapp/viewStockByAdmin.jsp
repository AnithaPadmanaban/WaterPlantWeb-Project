<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<script>
	function viewStock() {
		var url = "http://localhost:8080/WaterCanWebApp/ViewAvailabilityServlet";
		$.getJSON(url, function(response) {
			console.log(response);
			var data = response;
			var content = "";
			document.getElementById("stock").innerHTML = "";

			content += "<tr>";
			content += "<td>" + data.availability_stock + "</td>";
			content += "<td>" + data.inserted_date + "</td>";
			content += "</tr>";

			document.getElementById("stock").innerHTML = content;
		});
	}
</script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<form>
		<p>Available Stock</p>

		<div id="stock-section">
			<table border="1" class="table table-condensed">
				<thead>
					<tr>
						<th>Stock Availabilty</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody id="stock">
				</tbody>
			</table>
		</div>
		<input type="button" value="Cancel" class="btn btn-danger"
			onclick="window.location.href='adminView.jsp'">

		<script>
			viewStock();
		</script>
</body>
</html>