package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import controller.UserController;
import model.User;
import service.UserService;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		User user = new User();
		user.setEmail(userEmail);
		user.setPassword(userPassword);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		try {
			UserService userService = new UserService();
			
			UserController userController = new UserController(); 
			String userValue=userController.login(userEmail,userPassword);
			/*
			 * System.out.println(userId); User userResult = new User();
			 * 
			 * userResult.setUserId(userId); String json = new Gson().toJson(userResult);
			 * out.write(json); 
			 
			 */
			HttpSession session = request.getSession();
			session.setAttribute("USER_ID",userValue);
			System.out.println("Id"+userValue);
			out.write(userValue); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();

	}
}
