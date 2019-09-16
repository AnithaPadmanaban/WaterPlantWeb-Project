package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.WaterPlantDAO;
import service.UserService;


public class ViewAvailabilityServlet extends HttpServlet {
	WaterPlantDAO waterPlantDAO = new WaterPlantDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserService userService = new UserService(); 
		int val=userService.viewAvailableStock();
		
	JsonObject obj = new JsonObject();
	obj.addProperty("Availabe Stock", val);
		//Gson gson = new Gson();
       // String json = gson.toJson(val);
        PrintWriter out = response.getWriter();
      //  out.println(obj.toString());
	}
	
}
