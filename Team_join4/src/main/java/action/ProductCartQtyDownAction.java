package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductCartQtyDownService;
import vo.ActionForward;

public class ProductCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String product_name = request.getParameter("product_name");
		
		ProductCartQtyDownService productCartQtyDownService = new ProductCartQtyDownService();
		ProductCartQtyDownService.downCartQty(product_name,request);
		
		forward =new ActionForward("productCartList.shoes",true);
		
		return forward;
	}

}
