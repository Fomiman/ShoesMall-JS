package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserboardShowService;
import vo.ActionForward;
import vo.User_board;

public class UserboardShowAcrion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserboardShowService usserboardShowService = new UserboardShowService();
		
		ArrayList<User_board> boardList= usserboardShowService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("showPage", "userBoard.jsp");
		
		//forward = new ActionForward("menuTemplate.jsp", false);
		
		//return forward;
		return new ActionForward("mainTemplate.jsp", false);
		
	}

}
