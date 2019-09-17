package model;

import java.time.LocalDate;
import java.util.Date;

public class OrderCan {
	
	private int order_id;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_order_id() {
		return user_order_id;
	}
	public void setUser_order_id(int user_order_id) {
		this.user_order_id = user_order_id;
	}
	public int getCane_order() {
		return cane_order;
	}
	public void setCane_order(int cane_order) {
		this.cane_order = cane_order;
	}
	public LocalDate getOrdered_date() {
		return ordered_date;
	}
	public void setOrdered_date(LocalDate ordered_date) {
		this.ordered_date = ordered_date;
	}
	private int user_order_id;
	private int cane_order;
	private LocalDate ordered_date;
	
}
