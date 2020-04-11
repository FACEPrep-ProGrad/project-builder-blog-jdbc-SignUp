package controller;

/*
1.Go to the controller class SignUpController inside the src/controller package.
2.Create object for the model class User and for the dao class UserDAO.
3.Pass the User as argument to the signUp method.
4.Call the signUp method and store the return value in a integer value called checkUser.
*/

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet(urlPatterns= {"/signup"})
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignUpController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String email = request.getParameter("email"); //  get the email value from the jsp/html page
		String password = request.getParameter("password"); //  get the password value from the jsp/html page
		String confirmPassword = request.getParameter("confirmPassword"); //  get the confirm password value from the jsp/html page
		LocalDate date= LocalDate.now(); // Java 8 Time API used to get system date and time at a particular instance
		
		// Fill your code here
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setDate(date);
		UserDAO userDAO=new UserDAO();
		int checkUser;
		
		try {
			checkUser = userDAO.signUp(user); 
		
			if(checkUser!=0)
			{	
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println(user.getDate());
				request.setAttribute("message", "Registration Successful");
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("message", "Check your email and password");
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
				rd.forward(request, response);
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
