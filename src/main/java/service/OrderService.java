package service;

import dao.WaterPlantDAO;
import model.OrderCan;
import model.StockDetails;
import model.User;

public class OrderService {
	
	WaterPlantDAO waterPlantDAO = new WaterPlantDAO();
	UserService userService = new UserService();

	public void orderCan(User user, OrderCan order) {
		StockDetails availableStock =userService.viewAvailableStock();
		int totalCanAfterOrder = 0;
		System.out.println(availableStock);
		if (order.getCane_order() <= availableStock.getStockAvailability()) {
			waterPlantDAO.orderStock(user, order);
			totalCanAfterOrder = availableStock.getStockAvailability() - order.getCane_order() ;
			System.out.println(totalCanAfterOrder);
			waterPlantDAO.updateCan(totalCanAfterOrder);
		}

	}

}
