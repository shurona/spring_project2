package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//1. path 정보를 추출한다. 
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
		Controller ctrl = handlerMapping.getController(path);
		
		//3. 검색된 Controller를 실행한다.
		String viewName = ctrl.handleRequest(request, response);
		
		//4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		}else {
			view = viewName;
		}

		response.sendRedirect(view);
	}

}
