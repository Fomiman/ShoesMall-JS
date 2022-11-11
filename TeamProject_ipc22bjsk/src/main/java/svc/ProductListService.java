package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ProductDAO;
import vo.ProductTBL;

public class ProductListService {

	
		public ArrayList<ProductTBL> getProductList(HttpServletRequest request, int productPageNum, String orderbySelect){
			
			Connection con = getConnection();
			
			ProductDAO productDAO = ProductDAO.getInstance();
			
			productDAO.setConnection(con);
			
			ArrayList<ProductTBL> productList = productDAO.selectProductList(productPageNum, orderbySelect);
			int MaxProductPageNum = productDAO.maxPage();
			
			request.setAttribute("MaxProductPageNum", MaxProductPageNum);
			
			close(con);
			
			return productList;
			
			
		}

	

	
}
