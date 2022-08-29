package admin.RemoveUser;

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

@WebServlet(name = "/RemoveUser", urlPatterns = {"/RemoveUser"})

public class RemoveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UN = request.getParameter("SystemUser");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets a new connection
            PreparedStatement ps = c.prepareStatement("delete from login where username = ?");
            ps.setString(1, UN);
            int rs = ps.executeUpdate();
            
            if (rs > 0) 
            {
            	String show = "success";
            	request.setAttribute("check", show);
                RequestDispatcher rd = request.getRequestDispatcher("RemoveUser.jsp");
                rd.forward(request, response);
            }
            else 
            {
	            String show = "not success";
	            request.setAttribute("check", show);
	            RequestDispatcher rd = request.getRequestDispatcher("RemoveUser.jsp");
	            rd.forward(request, response);
            }
            
            }
            	catch (ClassNotFoundException | SQLException e) {
            	e.printStackTrace();
            }

	}

}
