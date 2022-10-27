package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.PostShowService;
import vo.ActionForward;
import vo.User_board;

public class postShowAcrion implements Action {


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PostShowService postShowService = new PostShowService();
		
		User_board showPost = postShowService.getPost(Integer.parseInt(request.getParameter("post_no")));
		
		request.setAttribute("showPost", showPost);
		request.setAttribute("showPage", "view.jsp");
		
		//forward = new ActionForward("menuTemplate.jsp", false);
		
		//return forward;
		return new ActionForward("mainTemplate.jsp", false);
		
	}

}
