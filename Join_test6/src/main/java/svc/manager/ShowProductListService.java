package svc.manager;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ManagerDAO;
import vo.ProductTBL;

public class ShowProductListService {

	public ArrayList<ProductTBL> allProductList() {
		Connection con = getConnection();
		
		ManagerDAO mgrDAO = ManagerDAO.getInstance();
		mgrDAO.setConnection(con);
		
		ArrayList<ProductTBL> productList = mgrDAO.allProductList();
		
		close(con);
		
		return productList;
	}
	
}
