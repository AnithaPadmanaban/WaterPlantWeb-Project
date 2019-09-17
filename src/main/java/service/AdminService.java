package service;

import java.sql.SQLException;

import dao.WaterPlantDAO;
import model.Admin;
import model.StockDetails;

public class AdminService {
	WaterPlantDAO waterPlantDAO = new WaterPlantDAO();

	public boolean adminLoginProcess(Admin admin) {
		Boolean value = waterPlantDAO.adminLogin(admin);
		return value;
	}

	public void updateCanByAdmin(int can) {
		StockDetails stockDetails;
		stockDetails = waterPlantDAO.viewStock();
		int updateCan = can + stockDetails.getStockAvailability();
		waterPlantDAO.updateCanByAdmin(updateCan);

	}
}
