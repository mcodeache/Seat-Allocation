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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "login.css">
</head>
<body>

	<form action ="DeAllocateSeat"  method = post autocomplete="off">
	<h2 style="text-align: center"> DeAllocate Employee Seat</h2>
    <div align="center" class = "container">
    <input type = "text" name = "EmployeeID" placeholder="Employee ID" required>
    <br>
    
    <input type = "text" name = "FirstName" placeholder="First Name"  required>
    <br>
    
    <input type = "text" name = "LastName" placeholder="Last Name" required>
    <br>
    
    <input type = "text" name = "SeatNo" placeholder = "Enter Seat No" required>
    <br>
    
	
        <button type = "submit" class = "btn" >Submit</button>
        <div class="popup" id = "popup">
            <img src = "images/tick.png">
            <h2>Thank You!</h2>
            <p>Employee Removed Successfully.</p>
            <button type = "submit" onclick="closePopup()">ok</button>
        </div>
        
         <div class="popup" id = "popup1">
            <img src = "images/cross.png">
            <h2>RE-Enter Details!</h2>
            <p>Please Check Input Details.</p>
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

