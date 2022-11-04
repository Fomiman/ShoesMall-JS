package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import vo.CartTBL;
import vo.ProductTBL;
import vo.ProductTBL;

public class ProductCartAddService {
	
	/*
	public ProductTBL getCartProduct(int product_no) {
		
		Connection con = getConnection();
		CartDAO cartDAO = CartDAO.getInstance();
		cartDAO.setConnection(con);
		
		ProductTBL cartTBL = cartDAO.selectCartTBL(product_no);
		close(con);
		
		return cartTBL;
		
	}
	*/

	//상품정보
	public ProductTBL getProduct(int product_no) {
		
		//커넥션 얻어옴
		Connection con = getConnection();
		//DAO객체 얻어옴
		ProductDAO productDAO = ProductDAO.getInstance();
		//연걸 설정
		productDAO.setConnection(con);
		
		//DAO 메서드로 값 가져옴
		 ProductTBL productInfo = productDAO.selectProductView(product_no);
		close(con);
		
		return productInfo;
	}
	
	@SuppressWarnings("unchecked")
	public void addCartTBL(HttpServletRequest request, ProductTBL productInfo) {
		HttpSession session = request.getSession();
		
		//세션에서 카트목록 가져옴
		ArrayList<CartTBL> cartList = (ArrayList<CartTBL>)session.getAttribute("cartList");
		
		//카트목록이 null이라면
		if(cartList == null) {
			cartList = new ArrayList<CartTBL>();
			session.setAttribute("cartList", cartList);
		}
		
		//장바구니에 없던 상품인지 체크하는 변수
		boolean isNewCartTBL = true;
		
		//장바구니 탐색
		//장바구니에 있는 항목이면 개수 +1
		for(int i =0; i <cartList.size();i++) {
			if(productInfo.getProduct_no() == (cartList.get(i).getProduct_no())) {
				isNewCartTBL = false;
				cartList.get(i).setProduct_amount(cartList.get(i).getProduct_amount()+1);
				break;
			}
		}
		
		//장바구니에 없는 상품인 경우
		if (isNewCartTBL) {
			//카트에 담음
			CartTBL cartTBL = new CartTBL();
			cartTBL.setProduct_no(productInfo.getProduct_no());//여기에 상품번호 추가
			cartTBL.setProduct_image(productInfo.getProduct_image());
			cartTBL.setProduct_name(productInfo.getProduct_name());
			cartTBL.setProduct_price(productInfo.getProduct_price());
			cartTBL.setProduct_amount(1);
			cartList.add(cartTBL);
		}
	}
	
	
}
