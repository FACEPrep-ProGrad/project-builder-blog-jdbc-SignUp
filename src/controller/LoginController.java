package controller;

import java.io.IOException;
//import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import businesslogic.ValidateUser;
import dao.UserDAO;
import model.User;
/*
1.Go to the controller class LoginController inside the src/controller package.
2.Create object for the model class User and for the dao class UserDAO.
3.Pass the User as argument to the loginUser.
4.Call the loginUser method and store the return value in a boolean value called validateUser.

*/

@WebServlet(urlPatterns= {"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
	rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); //  get the email value from the jsp/html page
		String password = request.getParameter("password"); //  get the password value from the jsp/html page

		// Fill your code
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.loginUser(user);
			boolean validateUser = userDAO.loginUser(user);
			
			if(validateUser) {
				System.out.println("Yes exist");
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
				rd.forward(request, response);
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
