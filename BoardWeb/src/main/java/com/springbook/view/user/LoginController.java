package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리!");
		//아이디와 패스워드를 request로 받아서
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		//이것을 UserVO객체에 넣은 다음 이에 해당하는 DB의 유저값을 받아온다. 

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		//해당 유저값이 존재하면 로그인 아니면 로그인 화면 유지
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
