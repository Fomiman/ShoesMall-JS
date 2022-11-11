package svc.manager;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.OrderDAO;

public class CancelOrderStatusServiece {

	public boolean cancelOrderStatus(int order_id, int order_status, String[] product_no, String[] order_amount) {
		boolean cancelSuccess = false;
		
		Connection con = getConnection();
		
		OrderDAO oDAO = OrderDAO.getInstance();
		
		oDAO.setConnection(con);
		
		boolean cancelStatus = oDAO.cancelOrderStatus(order_id);
		int increasedRow = 0;
		if (order_status == 1) { // 주문 승인상태에서 취소할 시에 승인할때 감소시킨 만큼 다시 증가 시켜야함(주문에는 변동이 없으니 메서드 형식 그대로 가져와서 +-만 변경)
			increasedRow = oDAO.ProductAmountIncrease(product_no, order_amount);
		}
		
		if(cancelStatus && (increasedRow == product_no.length)){ // 쿼리문 제대로 실행 + 제품 종류 수 만큼 수량증가 메서드가 실행되었는지 확인
			cancelSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return cancelSuccess;
	}

}
