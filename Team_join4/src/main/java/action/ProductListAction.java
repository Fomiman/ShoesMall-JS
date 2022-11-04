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
		
		ArrayList<String> todayImageList = new ArrayList<String>();
		
		Cookie[] cookieArray = request.getCookies();
		if(cookieArray != null) {
			for(int i= 0 ; i<cookieArray.length ; i++) {
				if(cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		request.setAttribute("productList", productList);
		request.setAttribute("todayImageList", todayImageList);
		
		forward = new ActionForward("product/product.jsp",false);
		
		return forward;
	}

}
