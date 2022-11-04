package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.InsertAddressService;
import vo.ActionForward;
import vo.Deliver_address;

public class InsertAddressAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int member_code = Integer.parseInt(request.getParameter("member_code"));
		String address1 = request.getParameter("address1"); 
		String address2 = request.getParameter("address2"); 
		String address3 = request.getParameter("address3"); 
		
		Deliver_address da = new Deliver_address();
		da.setMember_code(member_code);
		da.setAddress1(address1);
		da.setAddress2(address2);
		da.setAddress3(address3);
		
		InsertAddressService insertAddress = new InsertAddressService();
		boolean insertAdrSuccess = insertAddress.insertAddress(da);
		
		if(insertAdrSuccess == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주소등록 실패');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward("userMyPage.usr", true);//"로그인 폼 보기" 요청(리다이렉트 방식)
		}
		
		return forward;
	}

}
