package service;

import java.util.List;

import dao.WaterPlantDAO;
import model.Admin;
import model.OrderCan;
import model.ReserveCan;
import model.StockDetails;
import model.User;

public class UserService {

	WaterPlantDAO waterPlantDAO = new WaterPlantDAO();

	public void registerProcess(User user) {
		waterPlantDAO.register(user);
	}

	public int loginProcess(User user) {
		int userId = waterPlantDAO.login(user);
		System.out.println(userId);
		return userId;
	}

	
	
	public StockDetails viewAvailableStock()

	{
		StockDetails stockDetails = waterPlantDAO.viewStock();
		return stockDetails;

	}

	
}
