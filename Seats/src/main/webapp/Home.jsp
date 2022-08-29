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
<title>home</title>
<link rel = "stylesheet" href = "Home.css">
</head>
<body>

    <div class="topnav">
        <a href="Home.jsp">Home</a>
        <a href = "Floor.jsp">Floor</a>
        <a href = "Employee.jsp">Allocate Seat</a>
        <a href="DeAllocateSeat.jsp">DeAllocate Seat</a>
        <a href="changeSeat.jsp">Change Seat</a>
        <a href = "https://zoom.us/">Video Call</a>
        <a href = "LogReport.jsp">Log Report</a>
        <a href ="check.jsp">Search Details</a>
        <a href ="/Seats/logoutServlet">Log Out</a>
    </div>
    
</body>
</html>

<%-- <%
}

else
{
	response.sendRedirect("login.jsp");
}
%> --%>

