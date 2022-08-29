package admin.RegisterUser;

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

@WebServlet(name = "RegisterUser", urlPatterns = { "/RegisterUser" })
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterUserServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String UN = request.getParameter("username");
		String P = request.getParameter("password");
		String RP = request.getParameter("Repeat password");
		String isEqual = ""; 
		if(P.equals(RP)) 
		{ 
			isEqual = "true"; 
		} 
		else 
		{
			isEqual = "false"; 
		}
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
// loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets
																														// a
																														// new
																														// connection
			PreparedStatement ps = c.prepareStatement("insert into login value(?,?)");
			ps.setString(1, UN);
			ps.setString(2, P);
			int i = ps.executeUpdate();
			if (i > 0) {
				request.setAttribute("isEqual", isEqual);
				request.setAttribute("check", "success");
				RequestDispatcher rd = request.getRequestDispatcher("RegisterUser.jsp");
				rd.forward(request, response);
			}

			else {
				request.setAttribute("isEqual", isEqual);
				request.setAttribute("check", "not success");
				RequestDispatcher rd = request.getRequestDispatcher("RegisterUser.jsp");
				rd.forward(request, response);
			}

		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
