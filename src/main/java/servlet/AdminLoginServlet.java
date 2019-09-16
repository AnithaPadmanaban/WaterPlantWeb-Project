package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.User;
import service.UserService;


public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminEmail=request.getParameter("adminEmailName");
		String adminPassword=request.getParameter("adminPasswordName");
		Admin admin = new Admin();
		admin.setEmail(adminEmail);
		admin.setPassword(adminPassword);
		PrintWriter out=response.getWriter();
		
		   boolean isValidUser = false;
		      try {
		          UserService userService = new UserService ();
		          isValidUser = userService.adminLoginProcess(admin);
		      }catch(Exception e) {
		          e.printStackTrace();
		      }
		      if(isValidUser) {
		          response.sendRedirect("adminView.jsp");
		      }
		      else {
		          response.sendRedirect("index.jsp?message=Invalid Login Crendentials!!!");
		      }
	}

	
}
