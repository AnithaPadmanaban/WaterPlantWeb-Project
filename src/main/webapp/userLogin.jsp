<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<script>
function login() {
    
    event.preventDefault();
    var emailId = document.getElementById("userEmailId").value;
    var passwordId = document.getElementById("userPasswordId").value;
    var formData = "email=" + emailId + "&password=" + passwordId;
    console.log(formData);
    
    var url = "http://localhost:8080/WaterCanWebApp/LoginServlet?" + formData;
    console.log(url);
    //alert(url);
    var formData = {};
    $.get(url, function(response) {
        console.log(response);
       /*  var data = response;//JSON.parse(response);
        if (data.userId == 0) {
            alert("Invalid Username or Password");
          
        } 
        else if(data.userId >0)
            {
            window.location.href = "userView.jsp";
        } */

        var data= response;
        
        if(data.errorMessage == null) {
        	alert("Login Succesfull");
        	window.location.href= "userView.jsp";
        	
        }
        else
        	{
        	//alert(data.message);
        	alert(data.errorMessage);
        	}
    });
}
</script>
<%
String errorMessage = request.getParameter("errorMessage");
if(errorMessage!=null){
	out.println("<font color='red'>" + errorMessage + "</font>");
}
%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form onsubmit="login()">
<label>Email</label>
<input type="email" id="userEmailId" name="userEmailName"><br>
<label>Password</label>
<input type="password" id="userPasswordId" name="userPasswordName"><br>
<input type="button" class="btn btn-danger" onclick="window.location.href='index.jsp'"; value="Cancel">
<button type="reset" class="btn btn-warning" value="clear">Clear</button>
<input type="submit"  class="btn btn-success"  value="submit"><br>
</form>

</body>
</html>
