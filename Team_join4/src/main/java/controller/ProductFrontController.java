/**
 * ★★ Controller는 반드시 서블릿으로 만들기
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.OrderResultAction;
import action.ProductCartOrderAction;
import action.ProductCartAddAction;
import action.ProductCartListAction;
import action.ProductCartQtyDownAction;
import action.ProductCartQtyUpAction;
import action.ProductCartRemoveAction;
import action.ProductCartSearchAction;
import action.ProductListAction;
import action.ProductRegistAction;
import action.ProductViewAction;
import vo.ActionForward;

/**
 * Servlet implementation class DogFrontController
 */

/**
 * 1.먼저, DogFrontController의 요청 매핑을 *.dog로
 * 확장자가 dog이면 무조건 DogFrontController로 이동하여
 *
 */

@WebServlet("*.shoes") 
public class ProductFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//이 서블릿으로 들어오는 post나 get 방식의 모든 요청 처리
	protected void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //Post : 한글 파라미터 값 한글깨짐 방지
		
		//요청객체로부터 '프로젝트명 + 파일경로' 까지 가져옴 (예) /project/dogList.dog
        String requestURI = request.getRequestURI();
        //요청 URL : http://lacalhost:8090/project/dogList.dog
        //요청 URI : /project/dogList.dog
        
        //요청객체로부터 '프로젝트 path'만 가져옴 (예) /project
        String contextPath =  request.getContextPath();
        
        /*
         * URI에서 contextPath길이만큼 잘라낸  나머지 문자열 
         * /project/ dogList.dog - /project= /dogList.dog
         */
        
      String command = requestURI.substring(contextPath.length()); //(index8~끝까지) 부분문자열 반환
      
      Action action = null; //부모인터페이스
      ActionForward forward = null;
      
      if(command.equals("/productList.shoes")) { //'신발 상품 목록보기' 요청하면
    	action =  new ProductListAction();
      
    	try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
      }else     if(command.equals("/productView.shoes")) { //'개 상품 목록보기' 요청하면
      	action =  new ProductViewAction();
      
      
      	try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
      }else if(command.equals("/productRegistForm.shoess")) { //'새로운 개상품 정보 등록 폼인 뷰페이지보기'요청
    	  
			/*
			 * action = new DogViewAction();
			 * 
			 * try { forward = action.execute(request, response); } 
			 * catch (Exception e) { 
			 * e.printStackTrace(); }
			 */
    	  forward = new ActionForward("productRegistForm.jsp", false);//리다이렉트 방식: 새요청
      
	 }else if(command.equals("/productRegist.shoes")) { //'새로운 개상품 정보 등록을 처리하는'요청
			  action = new ProductRegistAction();
			  
			 try { forward = action.execute(request, response); } 
			  catch (Exception e) { 
			 e.printStackTrace(); 
			 }
   }
     /*----------------------장바구니---------------------------------------------------*/
	 else if(command.equals("/productCartAdd.shoes")) { //'새로운 장바구니 항목을 추가하는 장바구니 담기'요청이면
		  action = new ProductCartAddAction();
		  
		 try { forward = action.execute(request, response); } 
		  catch (Exception e) { 
		 e.printStackTrace(); 
		 }
} else if(command.equals("/productCartList.shoes")) { //'장바구니 목록 보기'요청이면
	  action = new ProductCartListAction();
	  
	 try { forward = action.execute(request, response); } 
	  catch (Exception e) { 
	 e.printStackTrace(); 
	 }

	} else if(command.equals("/productCartSearch.shoes")) { //'최하가격~최고가격'으로 장바구니 목록 검색
		  action = new ProductCartSearchAction();
		  
		 try { forward = action.execute(request, response); } 
		  catch (Exception e) { 
		 e.printStackTrace(); 
		 }
	} else if(command.equals("/productCartQtyUp.shoes")) { //'장바구니 항목 수량 증가' 요청이면
		  action = new ProductCartQtyUpAction();
		  
		 try { forward = action.execute(request, response); } 
		  catch (Exception e) { 
		 e.printStackTrace(); 
		 }
	} else if(command.equals("/productCartQtyDown.shoes")) { //'장바구니 항목 수량 감소' 요청이면
		  action = new ProductCartQtyDownAction();
		  
		 try { forward = action.execute(request, response); } 
		  catch (Exception e) { 
		 e.printStackTrace(); 
		 }
	}  else if(command.equals("/productCartRemove.shoes")) { //'장바구니 항목 삭제' 요청이면
		  action = new ProductCartRemoveAction();
		  
		 try { forward = action.execute(request, response); } 
		  catch (Exception e) { 
		 e.printStackTrace(); 
		 }
	}else if(command.equals("/productCartOrder.shoes")) { //'구매하기' 요청이면
		  action = new ProductCartOrderAction();
		  
		 try { forward = action.execute(request, response); } 
		  catch (Exception e) { 
		 e.printStackTrace(); 
		 }
	
	}else if(command.equals("/OrderResult.shoes")) { //'주문완료' 
		  action = new OrderResultAction();
		  
		 try { forward = action.execute(request, response); } 
		  catch (Exception e) { 
		 e.printStackTrace(); 
		 }
	
	}
      /************************
       * 포워딩
       * **********************************/
      if(forward != null) {
    	  if(forward.isRedirect()) {//true
    		  response.sendRedirect(forward.getPath()); //응답-새요청
    	  }else { //false : 디스패치-기존요청 전달 기존데이터 다사용가능
    		  request.getRequestDispatcher(forward.getPath()).forward(request, response);
    		  
    	  }
      }
      
	}
}

	


