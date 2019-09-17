
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Welcome To Register Page</h1>


<script>

function validateName()
{
var name=document.getElementById("userNameId").value;
var nameRegex=/^[A-Za-z]*$/;
if(nameRegex.test(name))
	{
	document.getElementById("nameError").innerHTML="";
	}
else
	{
	document.getElementById("nameError").innerHTML="Name should contain alphabets only";
	
	}
}
function validateEmail()
{
var email=document.getElementById("userEmailId").value;
var emailRegex=/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
if(emailRegex.test(email))
	{
	document.getElementById("emailError").innerHTML="";
	}
else
	{
	document.getElementById("emailError").innerHTML="Please enter valid email";
	
	}
}
function validatePassword()
{
var password=document.getElementById("userPasswordId").value;
var passwordRegex=/^[A-Za-z0-9]*$/;
if(passwordRegex.test(password))
	{
	document.getElementById("passwordError").innerHTML="";
	}
else
	{
	document.getElementById("passwordError").innerHTML="Password should contain alphabets or numbers";
	
	}
}

function registerServlet()
{
	event.preventDefault();
	var name = document.getElementById("userNameId").value;
	var email=document.getElementById("userEmailId").value;
	var password=document.getElementById("userPasswordId").value;
	var address=document.getElementById("userAddressId").value;
	
	var formData = "name=" +name + "&email="+ email +"&password="+ password+"&address="+address;
    var url = "http://localhost:8080/WaterCanWebApp/RegisterServlet?" + formData;
    console.log(url);
    $.get(url, function(response){
    console.log(response);
    var data= response;
    
    if ( data.errorMessage != null) {
    	alert(data.errorMessage);
    }
    else
    	{
    
    	alert("successfully registered");
    	//window.location.href= "userLogin.jsp";
    	}
       
    });
	
	}
</script>
<form onsubmit="registerServlet()">
<label>Enter Name</label>
<input type="text" id="userNameId" name="userName" onkeyup="validateName()"><span style="color:red" id="nameError"></span><br>
<label>Enter Email</label>

<input type="email" id="userEmailId" name="userEmailName" onblur="validateEmail()"><span style="color:red" id="emailError"></span><br>

<label>Enter Password</label>
<input type="password" id="userPasswordId" name="userPasswordName" maxlength="8" onkeyup="validatePassword()"><span style="color:red" id="passwordError"></span><br>
<label>Enter Address</label>
<textarea id="userAddressId" name="userAddressName"></textarea><br>
<input type="button" id="btnCancel" value="Cancel" class="btn btn-danger" onclick="window.location.href='index.jsp'">
<input type="submit" id="registerBtnId" class="btn btn-success" value="Register">
</form>
</body>
</html>