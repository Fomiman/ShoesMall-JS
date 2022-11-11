package svc.manager;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OrderDAO;

public class UpdateOrderStatusService {

	public boolean updateOrderStatus(int order_id, String[] product_no, String[] order_amount) {
		boolean updateSuccess = false;
		
		Connection con = getConnection();
		
		OrderDAO oDAO = OrderDAO.getInstance();
		
		oDAO.setConnection(con);
		
		boolean updateStatus = oDAO.updateOrderStatus(order_id);
		
		// 주문 승인 시 재고 수량 -1 변경하는 메서드(주문 승인은 무조건 -1 하면 되기 때문에 현재 order_status 필요 없음)
		int decreasedRow = oDAO.ProductAmountDecrease(product_no, order_amount);
		
		if(updateStatus && (decreasedRow == product_no.length)){ // 제품 종류 수 만큼 수량감소 메서드가 실행되었는지 확인
			updateSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		
		return updateSuccess;
	}

}
