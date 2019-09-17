package service;

import dao.WaterPlantDAO;
import model.Admin;

public class AdminService {
	WaterPlantDAO waterPlantDAO = new WaterPlantDAO();
	public boolean adminLoginProcess(Admin admin) {
		Boolean value = waterPlantDAO.adminLogin(admin);
		return value;

	}

}
