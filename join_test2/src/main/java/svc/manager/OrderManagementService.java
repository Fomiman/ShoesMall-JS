package svc.manager;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.ManagerDAO;
import vo.OrderTBL;

public class OrderManagementService {

	public ArrayList<OrderTBL> getOrderList() {
		Connection con = getConnection(); // import static db.JdbcUtil.*;
		
		ManagerDAO mgrDAO = ManagerDAO.getInstance();
		
		mgrDAO.setConnection(con);
		
		ArrayList<OrderTBL> orderList = mgrDAO.showList();
		
		close(con);
		
		return orderList;
	}

}
