package controller;

import com.google.gson.JsonObject;

import model.StockDetails;
import service.AdminService;
import service.UserService;

public class StockController {

	public StockDetails viewStock() {
		StockDetails stockDetails = null;
		UserService userService = new UserService();
		try {
			stockDetails = userService.viewAvailableStock();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockDetails;
	}

	
	public String updateStock(int can)
	{
		String errorMessage = null;
		String message = null;
		try{
		AdminService adminService=new AdminService();
		adminService.updateCanByAdmin(can);
		message = "Success";
		}
		catch(Exception e)
		{
			errorMessage = e.getMessage();
		}
		JsonObject obj = new JsonObject();
		if (message != null) {

			obj.addProperty("message", message);
		} else if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		return obj.toString();

	}
	
	
}
