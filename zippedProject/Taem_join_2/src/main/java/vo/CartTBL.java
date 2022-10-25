package vo;

public class CartTBL {
	private int cart_id;
	private int member_code;
	private int product_no;
	private int product_amount;
	
	public CartTBL() {
		super();
	}
	
	public CartTBL(int cart_id, int member_code, int product_no, int product_amount) {
		super();
		this.cart_id = cart_id;
		this.member_code = member_code;
		this.product_no = product_no;
		this.product_amount = product_amount;
	}
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	
	
	
	
}
