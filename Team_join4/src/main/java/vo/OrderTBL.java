package vo;

import java.util.Date;

public class OrderTBL {
	private int order_id;
	private String member_id;
	private int totalmoney;
	private int member_code;
	private Date order_date;
	private String order_status;
	

	public OrderTBL(int order_id, String member_id, int totalmoney, int member_code, Date order_date, String order_status) {
		super();
		this.order_id = order_id;
		this.member_id = member_id;
		this.totalmoney = totalmoney;
		this.member_code = member_code;
		this.order_date = order_date;
		this.order_status = order_status;
	}


	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(int totalmoney) {
		this.totalmoney = totalmoney;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	
	
}
