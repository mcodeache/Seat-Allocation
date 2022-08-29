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
<title>Update Employee Seat</title>

</head>
<link rel ="stylesheet" href = "UpdateEmployeeDetails.css">
<body>



<form action = "TempSeatChange" method = "post">
<h2 style="text-align: center">Update Employee Seat</h2>
<div align="center" class = "container">
<div class = "mylabel">
 	<label for = "EmployeeID">Employee ID:</label><input type = "number" name = "EmployeeID" placeholder = "EmployeeID"  value = "<%= request.getAttribute("EmployeeID") %>" required>
    <br>
 	<label for = "FirstName">First Name:</label><input type = "text" name = "FirstName" placeholder = "Enter First Name"  value = "<%= request.getAttribute("FirstName") %>" required>
    <br>
    
    <label for = "LastName">Last Name:</label><input type = "text" name = "LastName" placeholder="Enter Last Name" value = "<%= request.getAttribute("LastName") %>" required>
    <br>
    
     <label for = "EmailID">Email ID:</label><input type = "email" name = "EmailID" placeholder = "Enter New EmailID"  value = "<%= request.getAttribute("EmailID") %>" required>
    <br>
    
     <label for = "Floor">Floor:</label><input type = "text" name = "Floor" placeholder="Enter New Floor"  required>
    <br>
    
    <label for = "SeatNo">SeatNo:</label><input type = "text" name = "SeatNo" placeholder = "Enter New SeatNo" required>
    <br>
     
    <label for = "Project">Project:</label><input type = "text" name = "Project" placeholder="Enter New Project Name"  value = "<%= request.getAttribute("Project") %>"  required>
    <br>
    
    <label for = "Project Manager">Project Manager:</label><input type = "text" name = "ProjectManager" placeholder = "Enter New Project Manager"  value = "<%= request.getAttribute("ProjectManager") %>" required>
    <br>
    
    
    
	</div>
        <button type = "submit" class = "btn" >Submit</button>
        <div class="popup" id = "popup">
            <img src = "images/tick.png">
            <h2>Thank You!</h2>
            <p>Employee Details Updated Successfully.</p>
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