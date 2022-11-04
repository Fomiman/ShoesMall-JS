package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.PostShowAcrion;
import action.ShowNoticeAcrion;
import action.manager.InsertProductAction;
import action.manager.ManagerBoardWriteAction;
import action.manager.ManagerJoinAction;
import action.manager.ManagerLoginAction;
import action.manager.ManagerboardShowAcrion;
import action.manager.OrderDetailAction;
import action.manager.OrderManagementAction;
import action.manager.ServiceCenterAcrionMGR;
import action.manager.ShowProductDetailAction;
import action.manager.ShowProductListAction;
import action.manager.UserDataUpadate1Action;
import action.manager.UserDataUpadate2Action;
import action.manager.UserManagementDetailAction;
import action.manager.UserMangementAction;
import action.manager.WriteNoticeAction;
import vo.ActionForward;

/**
 * Servlet implementation class ManagerFrontController
 */
@WebServlet("*.mgr")
public class ManagerFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagerFrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 반드시 첫줄

		// 요청객체로부터 '프로젝트명+파일경로'까지 가져옴(예)/project/managerLogin.mgr
		String requestURI = request.getRequestURI();
		// 요청 URL : http://localhost:8090/project/managerLogin.mgr
		// 요청 URI : /project/managerLogin.mgr

		// 요청객체로부터 '프로젝트 path'만 가져옴(예)/project
		String contextPath = request.getContextPath();

		/*
		 * URI에서 contextPath길이만큼 잘라낸 나머지 문자열 /project/managerLogin.mgr - /project =
		 * "/managerLogin.mgr"
		 */
		String command = requestURI.substring(contextPath.length());// (index 8~끝까지) 부분문자열 반환

		/*
		 * 요청이 파악되면 해당 요청을 처리하는 각 Action클래스를 사용해서 요청 처리 각 요청에 해당하는 Action클래스 객체들을 다형성을
		 * 이용해서 동일한 타입(Action)으로 참조하기 위해 'Action 인터페이스' 타입의 변수 선언(혜574p)
		 */
		Action action = null;
		ActionForward forward = null;

		System.out.println("[Manager]command : " + command);// 어떤 요청인지 확인하기 위해 출력

		if (command.equals("/manager/managerHome.mgr")) {// 'index.jsp에서 managerHome.jsp뷰페이지 보기' 요청이면
			request.setAttribute("showPage", null);
			forward = new ActionForward("managerTemplate.jsp", false); // 반드시 디스패치 방식으로 포워딩
		}

		else if (command.equals("/manager/userHome.mgr")) {// '사용자 페이지로 이동'' 요청이면
			// 관리자 페이지에서 사용자 페이지로 이동할때 관리자 로그인 해제
			HttpSession session = request.getSession();
			session.removeAttribute("manager_id");
			session.removeAttribute("manager_pwd");

			request.setAttribute("showPage", null);
			forward = new ActionForward("../mainTemplate.jsp", true); // 반드시 디스패치 방식으로 포워딩
		}

		/****
		 * 로그인 / 로그아웃
		 *****************************************************************************/
		else if (command.equals("/manager/managerLogin.mgr")) {// '로그인 폼 보기' 요청이면
			request.setAttribute("showPage", "managerLogin.jsp");
			forward = new ActionForward("managerTemplate.jsp", false); // 반드시 디스패치 방식으로 포워딩
		}

		else if (command.equals("/manager/managerLoginAction.mgr")) {// '로그인 처리' 요청이면

			action = new ManagerLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/manager/managerLogoutAction.mgr")) {// '로그아웃' 요청이면
			HttpSession session = request.getSession();
			// session.invalidate();//세션의 모든 속성을 삭제-금지(세션에 저장된 사용자 속성도 제거되므로)
			session.removeAttribute("manager_id");
			session.removeAttribute("manager_pwd");

			request.setAttribute("showPage", null);
			forward = new ActionForward("managerTemplate.jsp", true);// 리다이렉트 방식으로 포워딩
		}

		/***** 관리자 추가 ******************************************/
		else if (command.equals("/manager/managerJoin.mgr")) {// '회원가입 폼 보기' 요청이면
			request.setAttribute("showPage", "managerJoin.jsp");
			forward = new ActionForward("managerTemplate.jsp", false);
		}

		else if (command.equals("/manager/managerJoinAction.mgr")) {// '회원가입 처리' 요청이면
			action = new ManagerJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*********************** 게시판 관리 **********************************************/
		else if (command.equals("/manager/userBoard.mgr")) {// '게시판 보기' 요청이면
			action = new ManagerboardShowAcrion();// 게시판 글 목록 불러오는 Action
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/manager/managerBoardWrite.mgr")) {// '글쓰기 폼 보기' 요청이면
			request.setAttribute("showPage", "../write.jsp");
			forward = new ActionForward("managerTemplate.jsp", false);
			// forward = new ActionForward("managerBoard.jsp", false); //반드시 디스패치 방식으로 포워딩
		}

		else if (command.equals("/manager/managerBoardWriteAction.mgr")) {// '글쓰기 처리' 요청이면
			action = new ManagerBoardWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('게시글이 성공적으로 등록되었습니다.');");
				out.println("history.back();");
				out.println("</script>");

			}
		}

		else if (command.equals("/manager/showPost.mgr")) {// '게시글 보기' 요청이면
			action = new PostShowAcrion();// 게시판 글 목록 불러오는 Action
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 서비스센터 관리
		 **********************************************************************************/
		else if (command.equals("/manager/serviceCenter.mgr")) {// '고객센터 보기' 요청이면
			action = new ServiceCenterAcrionMGR();// 게시판 글 목록 불러오는 Action
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} // 반드시 디스패치 방식으로 포워딩
		}

		else if (command.equals("/manager/writeNotice.mgr")) {// '공지등록 폼 보기' 요청이면
			request.setAttribute("showPage", "writeNotice.jsp");
			forward = new ActionForward("managerTemplate.jsp", false);
		}

		else if (command.equals("/manager/viewNotice.mgr")) {// '공지사항 보기' 요청이면
			action = new ShowNoticeAcrion();// 게시판 글 목록 불러오는 Action
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("게시판 글 불러오기 showNotice액션 오류" + e);
			}
		}

		else if (command.equals("/manager/writeNoticeAction.mgr")) {// '공지쓰기 처리' 요청이면
			action = new WriteNoticeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('게시글이 성공적으로 등록되었습니다.');");
				out.println("history.back();");
				out.println("</script>");

			}
		}
		/******** 주문/매출 관리 *********************************************************/
		else if (command.equals("/manager/orderManagement.mgr")) {// '실시간 주문관리 보기' 요청이면
			action = new OrderManagementAction();// 게시판 글 목록 불러오는 Action
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("OderManagementAction 에러 : " + e);
			}
		}

		else if (command.equals("/manager/orderDetail.mgr")) {// '실시간 주문관리 보기' 요청이면
			action = new OrderDetailAction();// 게시판 글 목록 불러오는 Action
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("OderManagementAction 에러 : " + e);
			}
		}

		/******** 회원 관리 *********************************************************/
		else if (command.equals("/manager/userManagement.mgr")) {// '회원관리 페이지 보기' 요청이면
			action = new UserMangementAction();// 회원 목록 불러오는 Action
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("회원관리 페이지 이동 액션 오류" + e);
			}
		}

		// userManageDetail.mgr
		else if (command.equals("/manager/userManageDetail.mgr")) {
			// 회원관리 페이지에서 회원 번호 누르면 회원정보 수정 페이지로 이동
			action = new UserManagementDetailAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("회원정보 수정 페이지 진입 액션 오류" + e);
			}

		}

		else if (command.equals("/manager/userDataUpdate1.mgr")) {
			// 회원정보 페이지 상단 회원정보 수정
			action = new UserDataUpadate1Action();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("회원정보 수정 액션 오류" + e);
			}

		}

		else if (command.equals("/manager/userDataUpdate2.mgr")) {
			// 회원관리 페이지 하단 회원 주소 수정
			action = new UserDataUpadate2Action();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("회원주소 수정 액션 오류" + e);
			}

		}

		/**************************** 상품 관리 ***********************************/
		// showProductList.mgr : 관리자용 상품목록 보기
		else if (command.equals("/manager/showProductList.mgr")) {
			action = new ShowProductListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("상품목록 보기 액션 오류" + e);
			}

		}

		// showProductDetail.mgr : 제품상세 버튼 누르면 제품 상세페이지(제품 수정/삭제 페이지)
		else if (command.equals("/manager/showProductDetail.mgr")) {
			action = new ShowProductDetailAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("제품상세 보기 액션 오류" + e);
			}

		}

		// insertProductPage.mgr : 상품등록 페이지 이동
		else if (command.equals("/manager/insertProductPage.mgr")) {

				request.setAttribute("showPage", "insertProductPage.jsp");
				forward = new ActionForward("managerTemplate.jsp", false);
		}

		// insertProduct.mgr : 상품등록 처리
		else if (command.equals("/manager/insertProduct.mgr")) {
			action = new InsertProductAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("상품등록 처리 액션 오류" +e);
			}

		}

		/***************************************************************
		 * 3.포워딩
		 ***************************************************************/
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());// "managerMain.jsp"
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}

	}

}
