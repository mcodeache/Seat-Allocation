<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "navBar.css">
</head>
<body>

 <div class="topnav">
 		
        <a href = "RegisterUser.jsp">Add SystemUser</a>
        <a href = "RemoveUser.jsp">Remove User</a>
        <a href ="EmployeeID.jsp">Update Employee</a>
        <a href = "TempSeats.jsp">Add BenchSeat</a>
        <a href = "TempSeatTable.jsp">BenchSeat Data</a>
        <a href ="getEmployeeDetails.jsp">Remove BenchSeat</a>
        <a href = "Home.jsp" target = "_blank">Access SystemUser</a>
        <select name = "forma" onchange = "location = this.value;">
          <option value = "" disabled selected hidden=>More</option>
	      <option value = "https://zoom.us/">Video Call</option>   
	      <option value = "LogReport.jsp">Log Report</option>
	      <option value = "check.jsp">Search Employee</option>
	      <option value = "AfterAdminLogin.jsp">Home</option>
	      <option value = "/Seats/logoutServlet">Log Out</option>
	      
	      
      </select>
    </div>
 

</body>
</html>