package action.manager;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.UpdateProductDetailService;
import vo.ActionForward;
import vo.ProductTBL;

public class UpdateProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null ;
		
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		String category_code = request.getParameter("category_code");
		String product_name = request.getParameter("product_name") ;
		int product_size = Integer.parseInt(request.getParameter("product_size"));
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		int product_amount = Integer.parseInt(request.getParameter("product_amount"));
		String product_decs = request.getParameter("product_decs");
		String product_date = request.getParameter("product_date");
		int product_hits = 0;
		String product_image = request.getParameter("product_image"); // 선택된 사진 파일명
		String product_image2 = ""; // 아래 생성자에 사용할 파일명 전달용 변수
		if(product_image.equals("")) { 
			// 바꿀 사진을 선택하지 않아서 값이  null 로 들어왔을때 기존 이미지 파일명 그대로 다시 가져와서 삽입
			product_image2 = request.getParameter("orgin_product_image");
		}else {
			// 사진을 선택했을 경우 선택된 파일명으로 update 진행
			product_image2 = product_image;
		}
		ProductTBL protbl = new ProductTBL(
				product_no, category_code, product_name, product_size, product_price, 
				product_amount, product_decs, product_date, product_hits, product_image2);
		
		
		UpdateProductDetailService updateProductDetailService = new UpdateProductDetailService();
		boolean updateProductSuccess = updateProductDetailService.updateProduct(protbl);
		
		if(updateProductSuccess == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품 수정 실패');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward("showProductList.mgr", false);
		}
		
		return forward;
	}

}
