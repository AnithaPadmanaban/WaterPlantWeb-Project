package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;


public class RegisterServlet extends HttpServlet {
	User user = new User();
	UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("userName");
		String email=request.getParameter("userEmailName");		
		String password=request.getParameter("userPasswordName");		
		String address=request.getParameter("userAddressName");		
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setAddress(address);
		
		userService.registerProcess(user);

	}


}
