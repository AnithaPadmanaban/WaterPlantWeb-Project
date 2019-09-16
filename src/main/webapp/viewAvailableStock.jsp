<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script>
function viewStock()
{
   var url = "http://localhost:8080/WaterCanWebApp/ViewAvailabilityServlet";
   $.getJSON(url, function(response){
       console.log(response);
       var data = response;
       var content="";
       document.getElementById("stock").innerHTML="";
       for(let stock of data){
           content += "<tr>";
           content += "<td>" + stock.cans_avail + "</td>";
           content += "<td>" + stock.date.day+"-"+stock.date.month+"-"+stock.date.year + "</td>";
           content += "</tr>";
       }
       document.getElementById("stock").innerHTML = content;
   });
}
</script>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<form>
<p>To see the stock available,press view button</p>
<button class="btn btn-danger" onclick="window.location.href='userView.jsp'">
<input type="submit" value="View" class="btn btn-success" onclick="viewStock()">
</body>
</html>