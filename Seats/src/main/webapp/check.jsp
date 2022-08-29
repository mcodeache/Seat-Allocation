<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<html>
<head>
<title>Search Page</title>
<link rel="stylesheet" href="login.css">
</head>
<body>

<%
String keyword = "";

if (request.getParameter("txtKeyword") != null) {

keyword = request.getParameter("txtKeyword");

}


%>
<form name="formSearch" method="get" action="check.jsp">
<div class="user-details">
<input name="txtKeyword" type="text"
id="txtKeyword" placeholder="SEARCH DETAILS" value="<%=keyword%>" required>
<div class="button">
<input type="submit" value="Search">

</div>
</div>

</form>

<%
Connection connect = null;

Statement statement = null;

try {

Class.forName("com.mysql.jdbc.Driver");

connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234");

statement = connect.createStatement();

String sql = "select * from employee where EmployeeID like '%"+keyword+"%' or FirstName like '%"+keyword+"%' or LastName like '%"+keyword+"%' or EmailID like '%"+keyword+"%' or Floor like '%"+keyword+"%' or SeatNo like '%"+keyword+"%' or Project like '%"+keyword+"%' or ProjectManager like '%"+keyword+"%'";

ResultSet resultset = statement.executeQuery(sql);
%>

<div class="table" align="center">
<table style = "width=650">

<tr>

<th width='600'>

<div align='center'>EmployeeID</div>

</th>

<th width='300'>

<div align='center'>FirstName</div>

</th>

<th width='300'>

<div align='center'>LastName</div>

</th>

<th width='300'>

<div align='center'>Email</div>

</th>

<th width='300'>

<div align='center'>Floor</div>

</th>

<th width='300'>

<div align='center'>SeatNo</div>

</th>

<th width='300'>

<div align='center'>Project</div>

</th>

<th width='300'>

<div align='center'>ProjectManager</div>

</th>

</tr>
<%


while (resultset.next()) {

%>
<tr align="center">
<td><div align="center"><%=resultset.getString("EmployeeID")%></div></td>
<td><%=resultset.getString("FirstName")%></td>
<td><%=resultset.getString("LastName")%></td>
<td><div align="center"><%=resultset.getString("EmailID")%></div></td>
<td align="right"><%=resultset.getString("Floor")%></td>
<td><div align="center"><%=resultset.getString("SeatNo")%></div></td>
<td><%=resultset.getString("Project")%></td>
<td><%=resultset.getString("ProjectManager")%></td>

</tr>
<%
}
%>

</table>
<%
} 
catch (Exception e) 
{
	out.println(e.getMessage());
	e.printStackTrace();
}
try 
{

if (statement != null) 
{
	statement.close();
	connect.close();
}

} 
catch (SQLException e) 
{
	out.println(e.getMessage());
	e.printStackTrace();
}
%>
</div>
</body>
</html>
