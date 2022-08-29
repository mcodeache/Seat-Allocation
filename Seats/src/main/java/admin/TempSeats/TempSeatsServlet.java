package admin.TempSeats;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "/TempSeats", urlPatterns = {"/TempSeats"})
public class TempSeatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TempSeatsServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		int Tseats = 10;
		String EID = request.getParameter("EmployeeID");
        String FN = request.getParameter("FirstName");
        String LN = request.getParameter("LastName");
        String E = request.getParameter("Email");
        String P = request.getParameter("Project");
        String PM = request.getParameter("ProjectManager");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
// loads driver
            Connection c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets a new connection
            PreparedStatement ps = c.prepareStatement("Select count(*) from TempSeats");//check seat taken or not
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	String getCount = rs.getString("Count(*)");
            	int allocated_seats = Integer.parseInt(getCount);
	            int available = Tseats - allocated_seats;
	            if(available > 0)
	            	{
	            		
		            	String Query ="insert into TempSeats(EmployeeID, FirstName, LastName, EmailID, Project, ProjectManager) value(?,?,?,?,?,?)";        	
		            	ps = c.prepareStatement(Query);
		            	
		            	ps.setString(1, EID);
		            	ps.setString(2, FN);
		            	ps.setString(3, LN);
		            	ps.setString(4, E);
		            	ps.setString(5, P);
		            	ps.setString(6, PM);
		            	
		            	int i  = ps.executeUpdate();
		            	
		            	if(i > 0)
		            	{
		            		String show = "success";
	            			request.setAttribute("check", show);
	            			request.setAttribute("allocated_seats", allocated_seats);
	            			request.setAttribute("available", available);
	                        RequestDispatcher rd = request.getRequestDispatcher("TempSeats.jsp");
	                        rd.forward(request, response);
		            	}
		            	
		            	else
		            	{
		            		String show = "not success";
	            			request.setAttribute("check", show);
	            			request.setAttribute("allocated_seats", allocated_seats);
	            			request.setAttribute("available", available);
	                        RequestDispatcher rd = request.getRequestDispatcher("TempSeats.jsp");
	                        rd.forward(request, response);
		            	}
	
	            	
	            	}
            }    
        }
            catch (ClassNotFoundException | SQLException e) 
            {
                	String show = "not success";
     	            request.setAttribute("check", show);
     	            RequestDispatcher rd = request.getRequestDispatcher("TempSeats.jsp");
     	            rd.forward(request, response);
            }
       
	}
}
