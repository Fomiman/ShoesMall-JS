package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.ProductTBL;

public class ProductViewService {

	public ProductTBL getProductTBLView (int product_no) {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		int updateCount = productDAO.updateReadCount(product_no);
		
		if(updateCount >0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		ProductTBL productTBL = productDAO.selectProductView(product_no);
		
		close(con);

		return productTBL;
	}
}