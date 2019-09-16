package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.CanStatus;
import model.User;
import service.UserService;

public class OrderCanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CanStatus canstatus = new CanStatus();
		UserService userService = new UserService();
		User user = new User();
		try {
			String canOrder = request.getParameter("orderCanName");

			HttpSession session = request.getSession(false);

			Integer userId = (Integer) session.getAttribute("USER_ID");
			System.out.println("User Id==>" + userId);
			int can = Integer.parseInt(canOrder);

			user.setUserId(userId);

			canstatus.setCanList(can);
			userService.orderCan(user, canstatus);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

}
