package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ProductCartListService;
import vo.ActionForward;
import vo.CartTBL;
import vo.ProductTBL;

public class ProductCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		// 서비스
		ProductCartListService productCartListService = new ProductCartListService();
		
		ArrayList<CartTBL> cartList = productCartListService.getCartList(request);
		
		
		if(cartList != null) {
		int totalMoney = 0;
		
		for (int i=0; i<cartList.size();i++) {
			totalMoney += cartList.get(i).getProduct_price() * cartList.get(i).getProduct_amount();
		}
		
		HttpSession session = request.getSession();
		
		//request.setAttribute("totalMoney", totalMoney);
		session.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		
		request.setAttribute("showPage", "product/productCartList.jsp");
		forward = new ActionForward("mainTemplate.jsp",false);
		
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('장바구니가 비어있습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
