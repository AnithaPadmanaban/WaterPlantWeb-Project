package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import connection.ConnectionUtil;
import model.Admin;
import model.OrderCan;
import model.ReserveCan;
import model.StockDetails;
import model.User;

public class WaterPlantDAO implements IWaterPlantDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;
	User user = new User();

	public int login(User user) {
		int userId=0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select user_id,user_email,user_password from user_info where user_email=? and user_password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			rs = pst.executeQuery();
			if (rs.next()) {
				
				 userId=rs.getInt("user_id");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}

		return userId;
	}

	public Boolean adminLogin(Admin admin) {

		Boolean result = false;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select admin_email,admin_password from admin_info where admin_email=? and admin_password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, admin.getEmail());
			pst.setString(2, admin.getPassword());
			rs = pst.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}

		return result;
	}

	public void register(User user) { /// method is used to
		/// insert registration
		/// details into DB

		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into user_info(user_name,user_password,user_email,user_address) values(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getAddress());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public StockDetails viewStock() { /// method is used to view available stock from DB
		int availableStock = 0;
		StockDetails stockDetails = new StockDetails(); 
		 
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from stock_details";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				 stockDetails.setStockAvailability(rs.getInt("stock_availability"));
				 Date date = rs.getDate("inserted_date");
				 stockDetails.setStockAddedDate(date.toLocalDate());
	               

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}
		return stockDetails;
	}

	
	public void orderStock(User user, OrderCan can) { /// method is used to insert userid and can ordered in DB

		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into order_info(user_order_id,cane_order) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, can.getCane_order());
			int rows = pst.executeUpdate();
			System.out.println(rows);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}
	}
		
		

	public void updateCan(int totalCanOrder) {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update stock_details set stock_availability=? where stock_id=1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, totalCanOrder);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public void insertReserveStock(User user, ReserveCan reserveCan) {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into reserve_info(user_reserve_id,cane_reserve) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, reserveCan.getCane_reserve());
			int rows = pst.executeUpdate();
			System.out.println(rows);
			


		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}

	}
	
	
	public void updateCanByAdmin(int can) {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update stock_details set stock_availability=? where stock_id=1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, can);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		finally {
			ConnectionUtil.close(con, pst);
		}
	}
		
	}

