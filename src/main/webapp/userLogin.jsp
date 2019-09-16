<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script>
function loginUser()
{
var userEmail=document.getElementById(userEmailId).value;
var userPassword=document.getElementById(userPasswordId).value;
var emailRegex=/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/; 

var passwordRegex=/^[a-zA-Z0-9]+$/;
if(userEmail.equals()&&userPassword.equals())
	{
	
	}
else
	{
	alert("Invalid Email or Password");
	}
	
	}
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="LoginServlet">
<label>Email</label>
<input type="email" id="userEmailId" name="userEmailName"><br>
<label>Password</label>
<input type="password" id="userPasswordId" name="userPasswordName"><br>
<input type="button" class="btn btn-danger" onclick="window.location.href='index.jsp'"; value="Clear">
<input type="submit" class="btn btn-success"  value="submit"><br>
</form>

</body>
</html>
