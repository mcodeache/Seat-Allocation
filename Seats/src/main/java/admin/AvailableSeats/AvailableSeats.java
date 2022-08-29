package admin.AvailableSeats;

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



@WebServlet(name = "/Floor", urlPatterns = {"/Floor"})
public class AvailableSeats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AvailableSeats() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 try 
		 {
			String Floor = request.getParameter("Floor");
		    int floor_no = Integer.parseInt(Floor);
			 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets a new connection
		    PreparedStatement ps = c.prepareStatement("select count(*) from employee where Floor = ? order by SeatNo");

		    request.getAttribute(Floor);
		    ps.setString(1, Floor);
		    int total_Seats = 0;

		    ResultSet rs = ps.executeQuery();
		    //int bench_seats = 10;
		    switch(floor_no)
		    {
			    case(1): total_Seats = 60;break;
			    case(2): total_Seats = 88;break;
			    case(3): total_Seats = 88;break;
			    case(4): total_Seats = 88;break;
			    case(5): total_Seats = 70;break;
		    }
		    
			  if(rs.next()) 
				  { 
					  String getCount = rs.getString("Count(*)"); 
					  int occupied = Integer.parseInt(getCount); 
					  int available = total_Seats - occupied; 
					  String available_seats = String.valueOf(available);
					  request.setAttribute("Allocated", getCount);
					  request.setAttribute("Available", available_seats);
					  request.setAttribute("floor", Floor); 
					  RequestDispatcher rd = request.getRequestDispatcher("Floor.jsp"); 
					  rd.forward(request, response); }
			  }
			  
		 
		 catch (ClassNotFoundException | SQLException e) 
		 {
			 String show = "not success";
	            request.setAttribute("check", show);
	            RequestDispatcher rd = request.getRequestDispatcher("changeSeat.jsp");
	            rd.forward(request, response);
		 }

	}

}
