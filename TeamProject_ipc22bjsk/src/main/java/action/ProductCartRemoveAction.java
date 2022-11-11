package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductCartRemoveService;
import vo.ActionForward;

public class ProductCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =null;
		
		String[] product_nameArray = request.getParameterValues("remove");
		
		if(product_nameArray != null) {

			ProductCartRemoveService.cartTBLRemove(request,product_nameArray);
			
		}else {
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 상품을 선택해주세요.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
		forward = new ActionForward("productCartList.shoes",true);
		return forward;
	}

}
