package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.CartTBL;
import vo.ProductTBL;

public class ProductCartQtyUpService {

	public static void upCartQty(String product_name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		ArrayList<CartTBL> cartList = (ArrayList<CartTBL>)session.getAttribute("cartList");
		
		for(int i = 0 ; i <cartList.size(); i++) {
			
			CartTBL cartTBL = cartList.get(i);
			
			if(cartTBL.getProduct_name().equals(product_name)) {
				cartTBL.setProduct_amount(cartTBL.getProduct_amount()+1);
				
			}
		}
	}

}
