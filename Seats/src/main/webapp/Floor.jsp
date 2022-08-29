<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*" %>
<%@ page import = "java.io.PrintWriter" %>

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
<title>Employee Details</title>
<link rel = "stylesheet" href = "login.css">
</head>
<body>
<div class = "bar">
<span class = "frameButtons">
 	<button onclick="show1()">Allocate Seat</button>
     <button onclick="show2()">DeAllocate Seat</button>	 
    <button onclick="show3()">Change Seat</button> 
</span> 
 	<a href="Home.jsp">
  	<img src="images/home1.png" class = "homeImage"style="width:42px;height:42px;border:0;">
</a>
</div>
 	<script>
 	var count1 = 0;
 	var count2 = 0;
 	var count3 = 0;
 	function show1()
 	{
 		
 		if(count1 == 0)
 			{
 				count1 += 1;
 				document.getElementById('current').src = 'Employee.jsp';
 				document.getElementById('current').classList.add("show");
 			}
 		else
 			{
 				count1 = 0;
 				document.getElementById('current').classList.remove("show");
 			}
 		
 		
 	}
 	function show2()
 	{
 		if(count2 == 0)
			{
				count2 += 1;
				document.getElementById('current').src = 'DeAllocateSeat.jsp';
		 		document.getElementById('current').classList.add("show");
			}
		else
			{
				count2 = 0;
				document.getElementById('current').classList.remove("show");
			}
		
 	}
 	function show3()
 	{
 		if(count3 == 0)
			{
				count3 += 1;
				document.getElementById('current').src = 'changeSeat.jsp';
		 		document.getElementById('current').classList.add("show");
			}
		else
			{
				count3 = 0;
				document.getElementById('current').classList.remove("show");
			}
 		
 	}
 	
 	</script>
 	

	
 <div class = "container" align = "center">
    <form class="example" action = "Floor" method = "post" id ="myform" autocomplete="off">
      
      <span class = "floor" style = "font-family:font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;"> Select Floor </span>
      <select name = "Floor" required>
      <option value = "" disabled selected hidden=>CHOOSE FLOOR</option>
      <!-- <option name = "select floor"> -->
      <option value = "1">1</option>
      <option value = "2">2</option>
      <option value = "3">3</option>
      <option value = "4">4</option>
      <option value = "5">5</option>
      </select>
      
      <input type = "submit" name = "submit">
      <br>
      
   </form>
</div> 
<div class ="table">
<table>
	
	<tr><th>Floor</th><th>Allocated Seats</th><th>Available Seats</th></tr>
	
	<% if (request.getAttribute("Allocated") == null)
	{
		request.setAttribute("Allocated", ""); 
		request.setAttribute("Available", "");
		request.setAttribute("floor", "");
	}
	%>
	<tr><td><%= request.getAttribute("floor") %></td><td><%= request.getAttribute("Allocated") %></td><td><%= request.getAttribute("Available") %></td></tr>

</table>
</div>

<%

try {
	
	String Floor = request.getParameter("Floor");
    Class.forName("com.mysql.cj.jdbc.Driver");
//loads driver
    Connection c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets a new connection
    PreparedStatement ps = c.prepareStatement("select * from employee where Floor = ? order by SeatNo");
    ps.setString(1, Floor); 
    ResultSet rs = ps.executeQuery();
    if (rs.next()) 	 
    {%>
        <div class = "table">
    	<table>
    	
    	<tr><th>EmployeeID</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Floor</th><th>SeatNo</th><th>Project</th><th>Project Manager</th></tr>
    	
    	<% do{ %>
    		<tr><td><%= rs.getString(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getString(3) %></td><td><%= rs.getString(4) %></td><td><%= rs.getString(5) %></td><td><%= rs.getString(6) %></td><td><%= rs.getString(7) %></td><td><%= rs.getString(8) %></td></tr>
    		
    		<%
    		 
    	}
    	while(rs.next());
    	%>
    		</table>
    		</div>
    		<%
    		
    	}
}

catch(Exception e)
{
	e.getStackTrace();
}
%>

 <div class = "frameTrigger" id = "show">
 <iframe id="current" src="Employee.jsp" title = "description"></iframe>
 </div>
<script>
	document.getElementById("myform").reset();
</script>
</body>
</html>

