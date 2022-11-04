package vo;


public class ProductTBL {
	private int product_no;
	private String category_code;
	private String product_name;
	private int product_size;
	private int product_price;
	private int product_amount;
	private String product_decs;
	private String product_date;
	private int product_hits;
	private String product_image;
	
	
	



	public ProductTBL(int product_no, String category_code, String product_name, int product_size, int product_price,
			int product_amount, String product_decs, String product_date, int product_hits, String product_image) {
		super();
		this.product_no = product_no;
		this.category_code = category_code;
		this.product_name = product_name;
		this.product_size = product_size;
		this.product_price = product_price;
		this.product_amount = product_amount;
		this.product_decs = product_decs;
		this.product_date = product_date;
		this.product_hits = product_hits;
		this.product_image = product_image;
		
	}


	public ProductTBL(String category_code, String product_name, int product_price, int product_amount) {
		super();
		this.category_code = category_code;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_amount = product_amount;
	}



	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_size() {
		return product_size;
	}

	public void setProduct_size(int product_size) {
		this.product_size = product_size;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_amount() {
		return product_amount;
	}

	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}

	public String getProduct_decs() {
		return product_decs;
	}

	public void setProduct_decs(String product_decs) {
		this.product_decs = product_decs;
	}

	public String getProduct_date() {
		return product_date;
	}

	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}

	public int getProduct_hits() {
		return product_hits;
	}

	public void setProduct_hits(int product_hits) {
		this.product_hits = product_hits;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	

	
}
