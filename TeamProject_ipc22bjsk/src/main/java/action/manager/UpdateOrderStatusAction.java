package action.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.UpdateOrderStatusService;
import vo.ActionForward;

public class UpdateOrderStatusAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null ;
		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		String[] product_no = request.getParameterValues("product_no");
		String[] order_amount = request.getParameterValues("order_amount");
		
		
		UpdateOrderStatusService updateOrderStatusService = new UpdateOrderStatusService();
		
		boolean updateSuccess = updateOrderStatusService.updateOrderStatus(order_id,product_no,order_amount);
		
		if(updateSuccess) {
			
			forward = new ActionForward("orderManagement.mgr", true);
		}else {
			response.setContentType("text/html,charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문승인실패');");
			out.println("history.back();");
			out.println("<script>");
		}
		
		return forward;
	}

}
