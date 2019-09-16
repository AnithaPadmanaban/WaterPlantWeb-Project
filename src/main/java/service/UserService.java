package service;

import dao.WaterPlantDAO;
import model.Admin;
import model.CanStatus;
import model.User;

public class UserService {
	WaterPlantDAO waterPlantDAO = new WaterPlantDAO();

	public void registerProcess(User user) {

		waterPlantDAO.register(user);
	}

	public int loginProcess(User user) {
		int userId = waterPlantDAO.login(user);
		return userId;

	}

	public void orderCan(User user, CanStatus order) {
		int availableStock = viewAvailableStock();
		int totalCanAfterOrder=0;
		System.out.println(availableStock);
		if (order.getCanList() <= availableStock) {
			waterPlantDAO.orderStock(user, order);
			totalCanAfterOrder=availableStock-order.getCanList();
			System.out.println(totalCanAfterOrder);
			waterPlantDAO.updateCan(totalCanAfterOrder);
		}
		

	}

	public boolean adminLoginProcess(Admin admin) {
		Boolean value = waterPlantDAO.adminLogin(admin);
		return value;

	}

	public int viewAvailableStock()

	{
		int availableCan = waterPlantDAO.viewStock();
		return availableCan;

	}

	public int reserveCan(User user, CanStatus canstatus) {
		int availableStock = viewAvailableStock();
		int totalCanAfterReserve=0;
		int reserveId=0;
		System.out.println(availableStock);
		if (canstatus.getCanList() <= availableStock) {
		 reserveId=waterPlantDAO.reserveStock(user, canstatus);
			totalCanAfterReserve=availableStock-canstatus.getCanList();
			System.out.println(totalCanAfterReserve);
			waterPlantDAO.updateCan(totalCanAfterReserve);
		return reserveId;
	}
}
}
