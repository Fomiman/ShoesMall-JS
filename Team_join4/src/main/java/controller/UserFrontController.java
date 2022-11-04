package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.UserJoinAction;
import action.UserLoginAction;
import vo.ActionForward;

/**
 * Servlet implementation class UserFrontController
 */
@WebServlet("*.usr")
public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserFrontController() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");//반드시 첫줄
			
		//요청객체로부터 '프로젝트명+파일경로'까지 가져옴(예)/project/userLogin.usr
		String requestURI=request.getRequestURI();
		//요청 URL : http://localhost:8090/project/userLogin.usr
		//요청 URI : /project/userLogin.usr
		
		//요청객체로부터 '프로젝트 path'만 가져옴(예)/project
		String contextPath=request.getContextPath();
		
		/* URI에서 contextPath길이만큼 잘라낸 나머지 문자열
		 * /project/userLogin.usr - /project = "/userLogin.usr"
		 */
		String command=requestURI.substring(contextPath.length());//(index 8~끝까지) 부분문자열 반환
		
		/* 요청이 파악되면 해당 요청을 처리하는 각 Action클래스를 사용해서 요청 처리
		 * 각 요청에 해당하는 Action클래스 객체들을 다형성을 이용해서 동일한 타입(Action)으로 참조하기 위해
		 * 'Action 인터페이스' 타입의 변수 선언(혜574p) 
		 */
		Action action = null;
		ActionForward forward = null;
		
		System.out.println("[User]command : " + command);//어떤 요청인지 확인하기 위해 출력		
		
		if(command.equals("/userHome.usr")) {//'index.jsp에서 userHome.jsp뷰페이지 보기' 요청이면			
			forward = new  ActionForward("userHome.jsp", false); //반드시 디스패치 방식으로 포워딩 
		}
		
		else if(command.equals("/userLogin.usr")) {//'로그인 폼 보기' 요청이면
			request.setAttribute("showPage", "login.jsp");
			forward = new ActionForward("mainTemplate.jsp", false);	//반드시 디스패치 방식으로 포워딩					
		}
		
		else if(command.equals("/userLoginAction.usr")) {//'로그인 처리' 요청이면
			action  = new UserLoginAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/userLogoutAction.usr")) {//'로그아웃' 요청이면
			HttpSession session = request.getSession();
			//session.invalidate();//세션의 모든 속성을 삭제-금지(세션에 저장된 사용자 속성도 제거되므로)
			session.removeAttribute("member_id");
			session.removeAttribute("member_pwd");
			
			forward = new ActionForward("userHome.jsp", true);//리다이렉트 방식으로 포워딩	
		}
		
		else if(command.equals("/join.usr")) {//'회원가입 폼 보기' 요청이면
			request.setAttribute("showPage", "join.jsp");
			forward = new ActionForward("mainTemplate.jsp", false);
		}
		
		else if(command.equals("/userJoinAction.usr")) {//'회원가입 처리' 요청이면
			action  = new UserJoinAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/userBoard.usr")) {//'게시판 보기' 요청이면
			forward = new ActionForward("userBoard.jsp", false);	//반드시 디스패치 방식으로 포워딩					
		}
		
		/***************************************************************
		 * 3.포워딩
		 ***************************************************************/
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());//"userMain.jsp"
			}else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
		
	}//doProcess

}
