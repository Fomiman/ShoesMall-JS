package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductListService;
import vo.ActionForward;
import vo.ProductTBL;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		ProductListService productListService = new ProductListService();
		
		ArrayList<ProductTBL> productList= productListService.getProductList();
		
		//오늘의 상품 없음 > 삭제
//		ArrayList<String> todayImageList = new ArrayList<String>();
		
	
//		Cookie[] cookieArray = request.getCookies();
//		if(cookieArray != null) {
//			for(int i= 0 ; i<cookieArray.length ; i++) {
//				if(cookieArray[i].getName().startsWith("today")) {
//					todayImageList.add(cookieArray[i].getValue());
//				}
//			}
//		}
//		request.setAttribute("todayImageList", todayImageList);
		
		request.setAttribute("productList", productList);
		request.setAttribute("showPage", "product/product.jsp");
		forward = new ActionForward("mainTemplate.jsp",false);
		
		return forward;
	}

}
