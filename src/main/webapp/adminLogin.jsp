<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>

<script>
function adminLogin()
{

	  event.preventDefault();
	    var emailId = document.getElementById("adminEmailId").value;
	    var passwordId = document.getElementById("adminPasswordId").value;
	    var formData = "email=" + emailId + "&password=" + passwordId;
	    console.log(formData);
	    
	    var url = "http://localhost:8080/WaterCanWebApp/AdminLoginServlet?" + formData;
	    console.log(url);
	    var formData = {};
	    $.get(url, function(response) {
	        console.log(response);
	  	        var data= JSON.parse(response);
	       if(data.errorMessage ==null) {

	    	   alert("Login Succesfully");
	        	window.location.href= "adminView.jsp";
	    	  
	    	   
	        	
	        }
	        else
	        	{
	        	  
	        	alert(data.errorMessage);
	        	window.location.href= "adminLogin.jsp";
		    	
	        	}
	    });
	}

</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form onsubmit="adminLogin()">
<h1>Admin Page</h1>
<label>Email</label>
<input type="email" id="adminEmailId" name="adminEmailName"><br>
<label>Password</label>
<input type="password" id="adminPasswordId" name="adminPasswordName"><br>
<input type="button" value="Clear" class="btn btn-danger"  onclick="window.location.href='index.jsp';">
<input type="submit" value="Submit" class="btn btn-success">
</form>
</body>
</html>