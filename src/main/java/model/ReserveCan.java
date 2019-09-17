package model;

import java.time.LocalDate;

public class ReserveCan {

	private Integer reserve_id;
	private Integer user_reserve_id;
	private Integer cane_reserve;
	private LocalDate reserve_date;

	public Integer getReserve_id() {
		return reserve_id;
	}

	public void setReserve_id(Integer reserve_id) {
		this.reserve_id = reserve_id;
	}

	public Integer getUser_reserve_id() {
		return user_reserve_id;
	}

	public void setUser_reserve_id(Integer user_reserve_id) {
		this.user_reserve_id = user_reserve_id;
	}

	public Integer getCane_reserve() {
		return cane_reserve;
	}

	public void setCane_reserve(Integer cane_reserve) {
		this.cane_reserve = cane_reserve;
	}

	public LocalDate getReserve_date() {
		return reserve_date;
	}

	public void setReserve_date(LocalDate reserve_date) {
		this.reserve_date = reserve_date;
	}

}
