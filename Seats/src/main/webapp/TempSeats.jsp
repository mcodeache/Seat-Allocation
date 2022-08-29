<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // tells browser to not store in cache
response.setHeader("Pragma", "no-cache"); // for older version of http like http 1.0, etc
	if(session.getAttribute("username") == null)
	{
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
%>     

    
<%@ include file = "navBar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title > Bench Seats </title>
<link rel = "stylesheet" href = "login.css">
</head>
<body>

<form action = "TempSeats" method = "post" autocomplete = "off">
<h2 style="text-align: center">Bench Seats</h2>
<div align="center" class = "container">

		 <h2 style="text-align: center"> Register Employee - Allocate Bench Seat</h2>

       	<input type = "number" placeholder="Employee ID" name = "EmployeeID" required>
        <br>

		<input type = "text" placeholder = "FirstName" name = "FirstName" required>
		<br>
		
		<input type = "text" placeholder = "LastName" name = "LastName" required>
		<br>
		
        <input type = "email" placeholder="Email Id" name = "Email" style = "color:grey;" required>
        <br>
		
		<input type = "text" placeholder = "Project" name = "Project" required>
		<br>
		
		<input type = "text" placeholder = "Project Manager" name = "ProjectManager" required>
		<br>

        <button type = "submit" class = "btn" >Submit</button>
        <div class="popup" id = "popup">
            <img src = "images/tick.png">
            <h2>Thank You!</h2>
            <p>Employee Bench Seat Created.</p>
            <button type = "submit" onclick="closePopup()">ok</button>
        </div>
        
         <div class="popup" id = "popup1">
            <img src = "images/cross.png">
            <h2>Please Check Input Details!</h2>
            <p>Wrong EmployeeId.</p>
            <button type = "submit" onclick="closePopup()">ok</button>
        </div>
 

</div>

</form>
	
	

<% 
if(request.getAttribute("check") == "success")
{
	request.removeAttribute("check");
%>
	<script>
		
		//let popup = document.getElementById("popup");

		
		document.onclick("click",openPopup());
		document.onclick("close",openPopup());
			
		function  openPopup()
		{
    		popup.classList.add("open-popup");

		}
		
		function  closePopup()
		{
    		popup.classList.remove("open-popup");	
    		
    	}
		
	</script>
	
<%
}

else if(request.getAttribute("check") == "not success")
{
	request.removeAttribute("check");
%>
	<script>
	
	//let popup = document.getElementById("popup1");

	
	document.onclick("click",openPopup());
	document.onclick("close",openPopup());
		
	function  openPopup()
	{
		popup1.classList.add("open-popup");

	}
	
	function  closePopup()
	{
		popup1.classList.remove("open-popup");	
		
	}
	
</script>

<%	
}
%>




</body>
</html>