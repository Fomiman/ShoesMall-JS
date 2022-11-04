package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ProductCartOrderService;
import vo.ActionForward;
import vo.CartTBL;
import vo.OrderTBL;
import vo.ProductTBL;

public class ProductCartOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		//총 주문금액 - request? session?
		//int totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
		
		
		HttpSession session = request.getSession();
		
//		int prouct_no = Integer.parseInt(request.getParameter("product_no"));
//		String product_name;
//		int order_amount;
//		int totalPrice;
		//값 4개 다 받아와서
		
		int totalMoney =  (int)session.getAttribute("totalMoney");
		
		ArrayList<CartTBL> cartList = (ArrayList<CartTBL>)session.getAttribute("cartList");
		
		if(cartList == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문할 제품을 선택해주세요.')");//알림창 띄우고
			out.println("history.back()");//이전상태로
			out.println("</script>");
		}else {
			ArrayList<ProductTBL> productList = new ArrayList<ProductTBL>();
			
			for(int i=0 ; i<cartList.size(); i++) {
				
				ProductTBL productTBL = new ProductTBL(
										cartList.get(i).getProduct_name(),
										cartList.get(i).getCategory_code(),
										cartList.get(i).getProduct_price(),
										cartList.get(i).getProduct_amount()
						
						);
				productList.add(productTBL);//productList에 추가
			}
		String member_id = (String)session.getAttribute("member_id");
			

			if(member_id == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 해주세요.');");//알림창 띄우고
				out.println("location.href='userLogin.usr';");//다시 로그인 폼보기 요청을 하고
				out.println("</script>");
			}else {
			
				System.out.println("totalMoney :" + totalMoney);
			ProductCartOrderService productCartOrderService = new ProductCartOrderService();
			
			boolean isOrderSuccess = productCartOrderService.orderShoes(member_id,productList);
			
			if(!isOrderSuccess) { 
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('주문실패');");//알림창 띄우고
				out.println("history.back();");//이전 상태로 돌아가고
				out.println("</script>");
			}else {
				
		
			session.setAttribute("productList", productList);
			session.setAttribute("totalMoney", totalMoney);
			
			session.removeAttribute("cartList");
			
			OrderTBL latestOrder = ProductCartOrderService.userLastOrder(member_id);
			
			session.setAttribute("latestOrder", latestOrder);
			
			forward = new ActionForward("product/successOrder.jsp",true);
			}
		  }
		}
		
		return forward;
	}

}
