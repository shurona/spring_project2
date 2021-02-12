package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController{

	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session){
		System.out.println("로그인 인증 처리!");
//		//아이디와 패스워드를 request로 받아서
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		
//		//이것을 UserVO객체에 넣은 다음 이에 해당하는 DB의 유저값을 받아온다. 
//
//		UserDAO userDAO = new UserDAO(); 
//		UserVO user = userDAO.getUser(vo);
//		
//		//해당 유저값이 존재하면 로그인 아니면 로그인 화면 유지
//		ModelAndView mav = new ModelAndView();
//		if (user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//		} else {
//			mav.setViewName("redirect:login.jsp");
//		}
//		return mav;
		UserVO user = userDAO.getUser(vo);
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		
		if(userDAO.getUser(vo)!= null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else return "login.jsp";
	}

}
