package tryThis;
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


@WebServlet(name = "DeAllocateSeat", urlPatterns = { "/DeAllocateSeat" })
public class DeAllocateSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeAllocateSeatServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String EID = request.getParameter("EmployeeID");
        String FN = request.getParameter("FirstName");
        String LN = request.getParameter("LastName");
        String SN = request.getParameter("SeatNo");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
// loads driver
            Connection c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets a new connection
            PreparedStatement ps = c.prepareStatement("delete from employee where EmployeeID = ? and FirstName = ? and LastName = ? and SeatNo= ?");
              ps.setString(1, EID);
              ps.setString(2, FN);
              ps.setString(3, LN);
              ps.setString(4, SN);
            int rs = ps.executeUpdate();
            
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            
            if (rs > 0) {
            	String show = "success";
            	request.setAttribute("check", show);
                RequestDispatcher rd = request.getRequestDispatcher("DeAllocateSeat.jsp");
//                response.sendRedirect("Home.jsp");
                rd.forward(request, response);
            }
            else {
            String show = "not success";
            request.setAttribute("check", show);
            RequestDispatcher rd = request.getRequestDispatcher("DeAllocateSeat.jsp");
            rd.forward(request, response);
//            	out.print("<h1>please try again</h1>");
            	//response.sendRedirect();
            	}
            response.getHeader("no-store");
            }
            catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            }


	}

}
