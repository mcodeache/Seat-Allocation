<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title> Login </title>

<link rel = "stylesheet" href = "login.css">

</head>
<body>

<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

 <h2 style="text-align: center"> LOGIN </h2>
  <div class = "container" >

    <form action="login" method = post autocomplete="off"> 

        <label for = "usrname"></label>
        <input type = "text"  name = "username" placeholder = "username" required>			
        <br>
        <label for = "psw"></label>
        <input type = "password" name = "password"placeholder = "password"  required>
        <br>
    	<input type = "submit" value = "SUBMIT" style="text-align: center">
    </form> 
   </div> 
   


</body>
</html>