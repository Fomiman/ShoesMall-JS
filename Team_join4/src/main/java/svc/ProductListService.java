package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.ProductTBL;

public class ProductListService {

	
		public ArrayList<ProductTBL> getProductList(){
			
			Connection con = getConnection();
			
			ProductDAO productDAO = ProductDAO.getInstance();
			
			productDAO.setConnection(con);
			
			ArrayList<ProductTBL> productList = productDAO.selectProductList();
			
			close(con);
			
			return productList;
			
			
		}

	

	
}
