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
<title>Insert title here</title>
</head>

<link rel = "stylesheet" href = "Table.css">

<body>

<h1 align = "center">Log Report </h1>

<%

try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234");
	PreparedStatement ps = c.prepareStatement("SELECT * FROM employee ORDER BY C_Time desc Limit 20;");
	ps.executeQuery();
	
	ResultSet rs = ps.executeQuery();
	    if (rs.next()) 	 
	    {%>
	        <div class ="table">
	    	<table>
	    	
	    	<tr><th>EmployeeID</th><th>FirstName</th><th>LastName</th><th>EmailID</th><th>Floor</th><th>SeatNo</th><th>Project</th><th>ProjectManager</th><th>C_Time</th></tr>
	    	
	    	<% do{ %>
	    		<tr><td><%= rs.getString(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getString(3) %></td><td><%= rs.getString(4) %></td><td><%= rs.getString(5) %></td><td><%= rs.getString(6) %></td><td><%= rs.getString(7) %></td><td><%= rs.getString(8) %></td><td><%= rs.getString(9) %></td></tr>
	    		
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

</body>
</html>

