package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class OrderbyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String orderby = request.getParameter("orderbySelect");
		
		System.out.println(orderby);
		
		forward = new ActionForward("userHome.usr",false);
		
		return forward;
	}

}
