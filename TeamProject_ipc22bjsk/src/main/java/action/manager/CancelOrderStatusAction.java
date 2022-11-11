package action.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.CancelOrderStatusServiece;
import vo.ActionForward;

public class CancelOrderStatusAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
ActionForward forward = null ;
		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		int order_status = Integer.parseInt(request.getParameter("order_status"));
		String[] product_no = request.getParameterValues("product_no");
		String[] order_amount = request.getParameterValues("order_amount");
		
		CancelOrderStatusServiece cancelOrderStatusServiece = new CancelOrderStatusServiece();
		
		boolean cancelSuccess = cancelOrderStatusServiece.cancelOrderStatus(order_id,order_status,product_no,order_amount);
		
		if(cancelSuccess) {

			forward = new ActionForward("orderManagement.mgr", true);
		}else {
			response.setContentType("text/html,charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문취소실패');");
			out.println("history.back();");
			out.println("<script>");
		}
		
		return forward;
	}

}
