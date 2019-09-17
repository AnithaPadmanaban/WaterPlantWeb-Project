package service;

import dao.WaterPlantDAO;
import model.ReserveCan;
import model.StockDetails;
import model.User;

public class ReserveService {

	WaterPlantDAO waterPlantDAO = new WaterPlantDAO();
	UserService userService = new UserService();
	
	public void reserveCanDetail(User user, ReserveCan reserveCan) {
		StockDetails availableStock =userService.viewAvailableStock();
		int totalCanAfterReserve = 0;
		int reserveId = 0;
		System.out.println(availableStock);
		if (reserveCan.getCane_reserve() <= availableStock.getStockAvailability()) {
			waterPlantDAO.insertReserveStock(user, reserveCan);
			totalCanAfterReserve = availableStock.getStockAvailability() - reserveCan.getCane_reserve();
			System.out.println(totalCanAfterReserve);
			waterPlantDAO.updateCan(totalCanAfterReserve);

		}

	}
}
