package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductCartQtyUpService;
import vo.ActionForward;

public class ProductCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String product_name = request.getParameter("product_name");
		
		ProductCartQtyUpService productCartQtyUpService = new  ProductCartQtyUpService();
		
		ProductCartQtyUpService.upCartQty(product_name,request);
		
		forward = new ActionForward("productCartList.shoes",true);
		return forward;
	}

}
