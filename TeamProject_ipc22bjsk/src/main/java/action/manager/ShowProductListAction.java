package action.manager;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.ShowProductListService;
import vo.ActionForward;
import vo.ProductTBL;

public class ShowProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String orderProduct = "";
		if(request.getParameter("orderProduct")==null) {
			orderProduct = "default";
		}else {
			orderProduct = request.getParameter("orderProduct");
		}
		
		int pageNum ;
		if(request.getParameter("pageNum")==null) { // 처음에 관리 목록 불러올때 페이지 1로 세팅
			pageNum = 1;
		}else {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));//페이지 이동 시 증감된 수치를 불러옴
		}
		
		ShowProductListService showProductList = new ShowProductListService();
		
		ArrayList<ProductTBL> productList = showProductList.allProductList(request, pageNum, orderProduct);
		
		request.setAttribute("orderProduct", orderProduct);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("productList", productList);
		request.setAttribute("showPage", "showProductList.jsp");
		
		forward = new ActionForward("managerTemplate.jsp", false);
		
		return forward;
	}

}
