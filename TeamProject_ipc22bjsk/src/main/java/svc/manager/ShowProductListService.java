package svc.manager;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ManagerDAO;
import vo.ProductTBL;

public class ShowProductListService {

	public ArrayList<ProductTBL> allProductList(HttpServletRequest request, int pageNum, String orderProduct) {
		Connection con = getConnection();
		
		ManagerDAO mgrDAO = ManagerDAO.getInstance();
		
		mgrDAO.setConnection(con);
		
		ArrayList<ProductTBL> productList = mgrDAO.allProductList(pageNum, orderProduct);
		
		//상품목록용 최대페이지 구하는 메서드
		int maxPage = mgrDAO.maxPagePM();
		close(con);
		
		request.setAttribute("maxPage", maxPage);
		return productList;
	}
	
}
