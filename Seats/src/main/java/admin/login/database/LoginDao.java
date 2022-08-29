package admin.login.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import admin.login.bean.LoginBean;
public class LoginDao {
	private String dbUrl="jdbc:mysql://localhost:3306/RegisterEmployee";
	private String dbUname="root";
	private String dbPassword="1234";
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	int res = 0;
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con= null;
		try {
			con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public int validate(LoginBean loginBean) {
		  loadDriver(dbDriver);
		  Connection con=getConnection();
		  
		  String sql="select * from admin where username=? and password=?";
		  String users = "select * from login where username = ? and password = ?";
		  
		  PreparedStatement ps;
		  try {
			  
			 
			  String uname = "admin";
			  
			  if(loginBean.getUsername().equals(uname))
			  {
				  ps=con.prepareStatement(sql);
				  ps.setString(1, loginBean.getUsername());
				  ps.setString(2, loginBean.getPassword());
				  ResultSet rs = ps.executeQuery();
				  boolean status = rs.next();
				  if (status == true)
				  {
					  res = 1;
				  }
				  else
				  {
					  res = 0;
				  }
				  
			  }
			  else
			  {
				  ps=con.prepareStatement(users);
				  ps.setString(1, loginBean.getUsername());
				  ps.setString(2, loginBean.getPassword());
				  ResultSet rs = ps.executeQuery();
				  boolean status = rs.next();
				  if (status == true)
				  {
					  res = 2;
				  }
				  else
				  {
					  res = 0;
				  }
			  }
			 
		  }
		  catch(SQLException e) {
			  e.printStackTrace();
		  }
		return res;
	}
	
}
