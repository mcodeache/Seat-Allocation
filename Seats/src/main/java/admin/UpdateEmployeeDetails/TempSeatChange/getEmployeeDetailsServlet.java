package admin.UpdateEmployeeDetails.TempSeatChange;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;


@WebServlet(name = "/getEmployeeDetails", urlPatterns = {"/getEmployeeDetails"})
public class getEmployeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public getEmployeeDetailsServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String EID = request.getParameter("EmployeeID");
		 
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");// loads driver
	            Connection c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets a new connection
	            String query1 = "select * from TempSeats where EmployeeID = ? ";
	            PreparedStatement ps1 = c.prepareStatement(query1);
	            ps1.setString(1, EID);
	            ResultSet rs = ps1.executeQuery();
	            if(rs.next())
	            {
	            	String EmployeeID = rs.getString("EmployeeID");
	            	String firstname = rs.getString("FirstName");
	            	String lastname = rs.getString("LastName");
	            	String email = rs.getString("EmailID");
	            	String project = rs.getString("Project");
	            	String projectManager = rs.getString("ProjectManager");
	            	
	            	request.setAttribute("EmployeeID", EmployeeID);
	            	request.setAttribute("FirstName",firstname);
	            	request.setAttribute("LastName",lastname);
	            	request.setAttribute("EmailID",email);
	            	request.setAttribute("Project",project);
	            	request.setAttribute("ProjectManager",projectManager);
	            	RequestDispatcher rd = request.getRequestDispatcher("TempSeatChange.jsp");
	            	rd.forward(request, response);	            
	            	
	            }	
	            else
	            {
	            	
	            	request.setAttribute("check","not success");
	            	RequestDispatcher rd = request.getRequestDispatcher("getEmployeeDetails.jsp");
	            	rd.forward(request, response);
	            }
	            }
	  
		 catch (ClassNotFoundException | SQLException e) 
	          {
			 	request.setAttribute("check","not success");
			 	RequestDispatcher rd = request.getRequestDispatcher("getEmployeeDetails.jsp");
			 	rd.forward(request, response);
	            	  
	          }

	  	}

	}

