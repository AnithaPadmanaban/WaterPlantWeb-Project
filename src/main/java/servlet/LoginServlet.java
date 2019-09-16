package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("userEmailName");
		String userPassword = request.getParameter("userPasswordName");
		User user = new User();
		user.setEmail(userEmail);
		user.setPassword(userPassword);
		PrintWriter out = response.getWriter();

		try {
			UserService userService = new UserService();
			int userId = userService.loginProcess(user);

			HttpSession session = request.getSession();
			session.setAttribute("USER_ID",userId);
			if (userId!=0) {
				System.out.println("Rght login");
				response.sendRedirect("userView.jsp");
			} else if (userId== 0) {
				System.out.println("wrong login");

				response.sendRedirect("index.jsp?message=Invalid Login Crendentials!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
