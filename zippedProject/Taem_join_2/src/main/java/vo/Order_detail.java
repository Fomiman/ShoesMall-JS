package vo;

public class Order_detail {
	private int order_detail_id;
	private int order_id;
	private int product_no;
	private int order_amount;
	private int order_price;
	
	public Order_detail() {
		super();
	}

	public Order_detail(int order_detail_id, int order_id, int product_no, int order_amount, int order_price) {
		super();
		this.order_detail_id = order_detail_id;
		this.order_id = order_id;
		this.product_no = product_no;
		this.order_amount = order_amount;
		this.order_price = order_price;
	}

	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	
	
	
}
