package admin.RegisterEmployee.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import admin.RegisterEmployee.bean.RegisterBean;


public class RegisterDao 
{
	private String dbUrl="jdbc:mysql://localhost:3306/RegisterEmployee";
	private String dbUname="root";
	private String dbPassword="1234";
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	int res = 0;
	
	public void loadDriver(String dbDriver)
	{
		try 
		{
			Class.forName(dbDriver);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() 
	{
		Connection con= null;
		try 
		{
			con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public int show(RegisterBean RegisterBean) 
	{
		  loadDriver(dbDriver);
		  Connection con=getConnection();
		  
		  String sql=" insert into employee(EmployeeID, FirstName, LastName, EmailID,Floor, SeatNo, Project, ProjectManager) value(?,?,?,?,?,?,?,?)";
		  
		  PreparedStatement ps;
		  try 
		  {
	
				  ps=con.prepareStatement(sql);
				  ps.setString(1, RegisterBean.getEmployeeID());
				  ps.setString(2, RegisterBean.getFirstName());
				  ps.setString(3, RegisterBean.getLastName());
				  ps.setString(4, RegisterBean.getEmail());
				  ps.setString(5, RegisterBean.getFloor());
				  ps.setString(6, RegisterBean.getSeatNo());
				  ps.setString(7, RegisterBean.getProject());
				  ps.setString(8, RegisterBean.getProjectManager());
				  
				  int i = ps.executeUpdate(); 
				  if (i != 0)
				  {
					  res += 1;
				  }
				  
		  }
		  catch(SQLException e) 
		  {
			  e.printStackTrace();
		  }
		return res;
	
	}
	
}
