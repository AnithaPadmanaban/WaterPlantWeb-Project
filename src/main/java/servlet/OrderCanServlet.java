package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.OrderCan;
import model.User;
import service.UserService;

public class OrderCanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderCan orderCan = new OrderCan(); 
		UserService userService = new UserService();
		User user = new User();
		try {
			String canOrder = request.getParameter("can");
			int can = Integer.parseInt(canOrder);
			
			HttpSession session = request.getSession(false);
			Integer userId = (Integer) session.getAttribute("USER_ID");
			System.out.println("User Id==>" + userId);
			

			user.setUserId(userId);

			orderCan.setCane_order(can);
			userService.orderCan(user, orderCan);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

}
