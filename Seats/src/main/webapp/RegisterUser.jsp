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
<title>Insert title here</title>
<link rel = "stylesheet" href = "login.css">
</head>
<body>

  <h2 style="text-align: center"> Register User </h2>
  <div class = "container" >

    <form action="RegisterUser" method = "post" autocomplete="off"> 

        <label for = "usrname"></label>
        <input type = "text" id = "usrname" name = "username" placeholder = "username" required>
        <br>
        <label for = "psw"></label>
        <input type = "password" id = "psw" name = "password"placeholder = "password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title = "must contain at least one number
        one uppercase letter
        one lowercase letter 
        and at least 8 or more characters" required>
        <br>
        <input type = "password" id = "RP" name = "Repeat password"  placeholder = "Repeat password" required>
        <br>
        <button type = "submit" class = "btn" >Submit</button>
        <div class="popup" id = "popup">
            <img src = "images/tick.png">
            <h2>Great!</h2>
            <p>System User Added Successfully.</p>
            <button type = "submit" onclick="closePopup()">ok</button>
        </div>
        
         <div class="popup" id = "popup1">
            <img src = "images/cross.png">
            <h2>System User Registration Failed!</h2>
            <p>Please Check: UserName Must Be Unique</p>
            <p>Please Ensure Both Password Matches.</p>
            <button type = "submit" onclick="closePopup()">ok</button>
        
        </div>
    </form> 
   </div>

   <div id = "message">
    <h3>Password must contain the following:</h3>
    <p id = "letter" class = "invalid">A <b>lowercase</b>letter</p> 
    <p id = "number" class = "invalid">A <b>number</b></p>
    <p id = "length" class= "invalid">minimum <b>8 characters</b></p>
   </div>

   <script src= "RegisterUser.js"></script>
	<!--  -->
	<% 
	
if(request.getAttribute("check") == "success" && request.getAttribute("isEqual") == "true")
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

else if(request.getAttribute("check") == "not success" | request.getAttribute("isEqual") == "false" )
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