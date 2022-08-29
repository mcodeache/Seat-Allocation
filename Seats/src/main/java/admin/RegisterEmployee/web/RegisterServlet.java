package admin.RegisterEmployee.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.RegisterEmployee.bean.RegisterBean;
import admin.RegisterEmployee.database.RegisterDao;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


@WebServlet(name = "Employee", urlPatterns = { "/Employee" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String EmployeeID = request.getParameter("EmployeeID");
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String Email = request.getParameter("Email");
		String Floor = request.getParameter("Floor");
		String SeatNo= request.getParameter("SeatNo");
		String Project = request.getParameter("Project");
		String ProjectManager = request.getParameter("Project Manager");
		
		RegisterBean registerBean=new RegisterBean();
		registerBean.setEmployeeID(EmployeeID);
		registerBean.setFirstName(FirstName);
		registerBean.setLastName(LastName);
		registerBean.setEmail(Email);
		registerBean.setFloor(Floor);
		registerBean.setSeatNo(SeatNo);
		registerBean.setProject(Project);
		registerBean.setProjectManager(ProjectManager);
		
		int seat = Integer.parseInt(SeatNo);
		int floor = Integer.parseInt(Floor);
		
		/*check if floor and seat entered are correct or not else redirect it*/
         
          if ((seat > 60 && floor == 1) | (seat > 88 && floor == 2) )
          {
        	  	request.setAttribute("check", "not success");
	            RequestDispatcher rd = request.getRequestDispatcher("Employee.jsp");
	            rd.forward(request, response); 
          }
          
          else if ((seat > 88 && floor == 3) | (seat > 88 && floor == 4))
          {
        	  	request.setAttribute("check", "not success");
	            RequestDispatcher rd = request.getRequestDispatcher("Employee.jsp");
	            rd.forward(request, response);
          }
          else if ( seat > 70 && floor == 5)
          {
        	  	request.setAttribute("check", "not success");
	            RequestDispatcher rd = request.getRequestDispatcher("Employee.jsp");
	            rd.forward(request, response);
          }
          else if(floor > 5)
          {
        	  request.setAttribute("check", "not success");
	            RequestDispatcher rd = request.getRequestDispatcher("Employee.jsp");
	            rd.forward(request, response); 
          }
         
          else
          {
        	  try
        	  {
        		  RegisterDao registerDao =new RegisterDao();
        		  if(registerDao.show(registerBean) == 1) 
        		  {

	      			 String to = Email;// change accordingly
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
		      			   message.setText("Hey " + FirstName +" " +LastName  + "Your Allocated Floor is: " + Floor + "And  Seat No is: " + SeatNo);
		      			   Transport.send(message);
		      			   System.out.println("message sent successfully...");
	      			  } 
	      			  catch (MessagingException e) 
	      			  {
	      				  throw new RuntimeException(e);
	      			  }
	      			  
	      			  
	      			  request.setAttribute("check", "success");
	      			  RequestDispatcher rd = request.getRequestDispatcher("Employee.jsp");
	      			  rd.forward(request, response);
        		  }
        		  
        		  else
        		  {
      			
      	            request.setAttribute("check", "not success");
      	            RequestDispatcher rd = request.getRequestDispatcher("Employee.jsp");
      	            rd.forward(request, response);
      			  }
		}
		catch (Exception e)
      		{
			 	System.out.println("error");
      		}
          }
	}
	
}
