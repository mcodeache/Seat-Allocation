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
<title>Register System User</title>
<link rel = "stylesheet" href = "login.css">
</head>
<body>

	<form action ="RemoveUser" method = post>
	<h2 style="text-align: center"> Remove User </h2>
    <div align="center" class = "container">
    <input type = "text" name = "SystemUser" placeholder="UserName" required> <!-- UserName is primary key -->
	<br>
       
      <button type = "submit" class = "btn" >Submit</button>
        <div class="popup" id = "popup">
            <img src = "images/tick.png">
            <h2>Done!</h2>
            <p>System User Removed Successfully.</p>
            <button type = "submit" onclick="closePopup()">ok</button>
        </div>
        
         <div class="popup" id = "popup1">
            <img src = "images/cross.png">
            <h2>Please Check Entered details!</h2>
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