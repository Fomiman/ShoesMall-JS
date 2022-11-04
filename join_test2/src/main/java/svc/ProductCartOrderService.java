package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;
import dao.ProductDAO;
import vo.OrderTBL;
import vo.ProductTBL;

public class ProductCartOrderService {

	public boolean orderShoes(String member_id,ArrayList<ProductTBL> productList) {
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		int insertOrder = productDAO.insertProduct(member_id,productList);
		
		boolean isOrderResult = false;
		if(insertOrder > 0) {
			isOrderResult = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		 return isOrderResult;
	}
	
	public static OrderTBL userLastOrder(String member_id) {
		
		Connection con = getConnection();
		
		OrderDAO orderDAO = OrderDAO.getInstance();
		
		orderDAO.setConnection(con);
		
		OrderTBL latestOrder = orderDAO.selectLatestOrder(member_id);
		
		close(con);
		return latestOrder;
		
	}

	
}
