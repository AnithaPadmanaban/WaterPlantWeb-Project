<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<script>
function validation()
{
	var can=document.getElementById("adminCanId").value;
	var regex=/^[0-9]*$/;
	if(regex.test(can))
	{
	document.getElementById("canUpdateError").innerHTML="";
	document.getElementById("btnAddStockId").disabled="false";
	}
else
	{
	document.getElementById("canUpdateError").innerHTML="Invalid Input";
	document.getElementById("btnAddStockId").disabled="true";
	
	}
	}

function updateCan()
{
var canUpdate=document.getElementById("adminCanId").value;
var formData="canUpdate="+canUpdate;
var url="http://localhost:8080/WaterCanWebApp/UpdateStockServlet?" +formData;
$.get(url, function(response){
    console.log(response);
    var data= response;
    
    if ( data.errorMessage != null) {
    	alert(data.errorMessage);
    }
    else
    	{
    
    	alert("successfully Updated");
    	window.location.href= "adminView.jsp";
    	}
       
    });

	}
</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form onsubmit="updateCan()">
<h1>Enter Number of can to be added in Database</h1>
<label>Enter No of Can</label><br>
<input type="text" id="adminCanId" onkeyup="validation()"><span id="canUpdateError" style="color:red"></span><br>
<input type="submit" id="btnAddStockId" class="btn btn-success" disabled value="Add Stock">
</body>
</html>