package admin.UpdateEmployeeDetails.TempSeatChange;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/TempSeatChange", urlPatterns = {"/TempSeatChange"})
public class TempSeatChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TempSeatChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int seat = 80;
		String SN = request.getParameter("SeatNo");
		String F = request.getParameter("Floor");
		String EID = request.getParameter("EmployeeID");
        String FN = request.getParameter("FirstName");
        String LN = request.getParameter("LastName");
        String E = request.getParameter("EmailID");
        String P = request.getParameter("Project");
        String PM = request.getParameter("ProjectManager");
        
        int seatNo = Integer.parseInt(SN);
        
        if(seatNo > seat)
        {
        	String show = "not success";
            request.setAttribute("check", show);
            RequestDispatcher rd = request.getRequestDispatcher("TempSeatChange.jsp");
            rd.forward(request, response);
        }
        
        else
        {
        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	// loads driver
	            Connection c = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RegisterEmployee", "root", "1234"); // gets a new connection
	            PreparedStatement ps = c.prepareStatement("delete from TempSeats where EmployeeID = ?");//check seat taken or not
	              ps.setString(1, EID);
	            int rs = ps.executeUpdate();
	            
	            if (rs > 0) 
	            {
	            	String query = "insert into employee(EmployeeID, FirstName, LastName, EmailID,Floor, SeatNo, Project, ProjectManager) value(?,?,?,?,?,?,?,?)";
	            	ps = c.prepareStatement(query);
	            	 ps.setString(1, EID);
	                 ps.setString(2, FN);
	                 ps.setString(3, LN);
	                 ps.setString(4, E);
	                 ps.setString(5, F);
	                 ps.setString(6, SN);
	                 ps.setString(7, P);
	                 ps.setString(8, PM);
	                 int i = ps.executeUpdate();
	            	 if (i > 0)
	            		{
	            		 String to = E;// change accordingly
	          			 String from = "aryanmittal4665@gmail.com";
	          			 String password = "xuatbixrscybtxja";
	          			 String sub = "Seat Allocated";
	          			 Properties props = new Properties();     			  
	          			 props.put("mail.smtp.host", "smtp.gmail.com");
	          			 props.put("mail.smtp.socketFactory.port", "465");
	          			 props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	          			 props.put("mail.smtp.auth", "true");
	          			 props.put("mail.smtp.port", "465");
	          			 Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator()
	          			 {
	          				 protected PasswordAuthentication getPasswordAuthentication() {
	          				 return new PasswordAuthentication(from, password);
	          			  }
	          			  });
	      
	          			  try {
	    	      			   MimeMessage message = new MimeMessage(session);
	    	      			   message.setFrom(new InternetAddress(from));
	    	      			   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	      			   message.setSubject(sub);
	    	      			   message.setText("Hey " + FN +" " +LN+ "," + "Your Seat Has been Alloted to Floor : " + F + " And Seat No : " + SN);
	    	      			   // send the message
	    	      			   Transport.send(message);
	    	      			   System.out.println("message sent successfully...");
	          			  } 
	          			  catch (MessagingException e) 
	          			  {
	          				  throw new RuntimeException(e);
	          			  }
	        
	            			String show = "success";
	            			request.setAttribute("check", show);
	                        RequestDispatcher rd = request.getRequestDispatcher("TempSeatChange.jsp");
	                        rd.forward(request, response);
	            		}
	            }
	            else 
	            {
		            String show = "not success";
		            request.setAttribute("check", show);
		            RequestDispatcher rd = request.getRequestDispatcher("TempSeatChange.jsp");
		            rd.forward(request, response);
	            }
	            response.getHeader("no-store");
	            
	        }
		
	            catch (ClassNotFoundException | SQLException e) 
	        {
	            	 String show = "not success";
	 	            request.setAttribute("check", show);
	 	            RequestDispatcher rd = request.getRequestDispatcher("TempSeatChange.jsp");
	 	            rd.forward(request, response);
	        }
        }

	}

}
