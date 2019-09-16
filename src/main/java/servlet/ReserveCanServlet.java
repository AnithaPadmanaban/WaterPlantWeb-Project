package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CanStatus;
import model.User;
import service.UserService;


public class ReserveCanServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CanStatus canstatus = new CanStatus();
		UserService userService = new UserService();
		User user = new User();
		try {
			String canReserve = request.getParameter("reserveCanName");
			int can = Integer.parseInt(canReserve);
			
			HttpSession session = request.getSession(false);
			Integer userId = (Integer) session.getAttribute("USER_ID");
			System.out.println("User Id==>" + userId);
			

			user.setUserId(userId);

			canstatus.setCanList(can);
			int reserveId=userService.reserveCan(user, canstatus);
		} catch (Exception e) {
			System.out.println("Error");
		}
		
	}

}
