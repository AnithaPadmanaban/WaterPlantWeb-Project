package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AdminController;
import model.Admin;
import model.User;
import service.UserService;


public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminEmail=request.getParameter("email");
		String adminPassword=request.getParameter("password");
		Admin admin = new Admin();
		admin.setEmail(adminEmail);
		admin.setPassword(adminPassword);
		PrintWriter out=response.getWriter();
		
		 AdminController adminController = new AdminController();
		 String value=adminController.adminLogin(admin);
		 out.write(value);
		 out.flush();
	}

	
}
