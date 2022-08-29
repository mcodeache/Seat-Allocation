package admin.UpdateEmployeeDetails;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/UpdateEmployeeDetails", urlPatterns = {"/UpdateEmployeeDetails"})
public class UpdateEmployeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateEmployeeDetailsServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String EID = request.getParameter("EmployeeID"); 
		String E = request.getParameter("EmailID"); 
		String P = request.getParameter("Project"); 
		String PM = request.getParameter("ProjectManager");
		String FN = request.getParameter("FirstName"); 
		String LN = request.getParameter("LastName");
															
			
			try {
	            Class.forName("com.mysql.cj.jdbc.Driver"); // loads driver
	            Connection c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets a new connection
	            String query = "update employee set EmailID = ?,Project = ?, ProjectManager = ?,FirstName = ?,LastName= ? where EmployeeID = ?";
	              PreparedStatement	ps = c.prepareStatement(query);
	                   ps.setString(1, E);
	                   ps.setString(2, P);
	                   ps.setString(3, PM);
	                   ps.setString(4, FN);
	                   ps.setString(5, LN);
	                   ps.setString(6, EID);
	                   
	                   ps.executeUpdate();
	              			String show = "success";
	              			request.setAttribute("check", show);
	                        RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployeeDetails.jsp");
	                        rd.forward(request, response);
	              		
						/*
						 * else { String show = "not success"; request.setAttribute("check", show);
						 * RequestDispatcher rd =
						 * request.getRequestDispatcher("UpdateEmployeeDetails.jsp");
						 * rd.forward(request, response); }
						 */
	              	
	              response.getHeader("no-store");
	              
	          }
	  	
	              catch (ClassNotFoundException | SQLException e) 
	          {
	            	  String show = "not success";
		  	            request.setAttribute("check", show);
		  	            RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployeeDetails.jsp");
		  	            rd.forward(request, response);
	          }

	  	}

}

