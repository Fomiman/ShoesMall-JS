package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;

import action.ProductCartAddAction;
import action.ProductCartListAction;
import action.ProductCartQtyDownAction;
import action.ProductCartQtyUpAction;
import action.ProductCartRemoveAction;
import action.ProductListAction;
import action.ProductViewAction;

/**
 * Servlet Filter implementation class DogFrontControllerFilter
 */
/* @WebFilter("*.dog") */
public class ProductFrontControllerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ProductFrontControllerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String requestURI = request.getRequestURI();
    	// /project/boardWriteForm.bo
    	String contextPath = request.getContextPath();
    	// /project
    	String command = 
        requestURI.substring(contextPath.length());
    	//  /boardWriteForm.bo
    	
    	Action action = null;
    	   //�� Action ��ü ���� ������ �����ϰ� �ִ� �������̽�.
    	//��û�� ó���� �� �ش� ��û�� ó���� Action ��ü���� �ϳ��� �����ؼ�
    	//�ش� ��ü�� Action �������̽��� ���۷��� ������ ������..

    	
    	ActionForward forward = null;
    	
    	if(command.equals("/productList.shoes")){
    		action = new ProductListAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else if(command.equals("/productView.shoes")){
    		action = new ProductViewAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	else if(command.equals("/productCartAdd.shoes")){
    		action = new ProductCartAddAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	else if(command.equals("/productCartList.shoes")){
    		action = new ProductCartListAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else if(command.equals("/productCartRemove.shoes")){
    		action = new ProductCartRemoveAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else if(command.equals("/productCartQtyUp.shoes")){
    		action = new ProductCartQtyUpAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else if(command.equals("/productCartQtyDown.shoes")){
    		action = new ProductCartQtyDownAction();
    		try{
    			forward = action.execute(request, response);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	
    	
    	if(forward != null){
    		if(forward.isRedirect()){
    			response.sendRedirect(forward.getPath());
    		}
    		else{
    			RequestDispatcher dispatcher
    			= request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
