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
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session){
		System.out.println("�α��� ���� ó��!");
//		//���̵�� �н����带 request�� �޾Ƽ�
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		
//		//�̰��� UserVO��ü�� ���� ���� �̿� �ش��ϴ� DB�� �������� �޾ƿ´�. 
//
//		UserDAO userDAO = new UserDAO(); 
//		UserVO user = userDAO.getUser(vo);
//		
//		//�ش� �������� �����ϸ� �α��� �ƴϸ� �α��� ȭ�� ����
//		ModelAndView mav = new ModelAndView();
//		if (user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//		} else {
//			mav.setViewName("redirect:login.jsp");
//		}
//		return mav;
		UserVO user = userDAO.getUser(vo);
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
		}
		
		if(userDAO.getUser(vo)!= null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else return "login.jsp";
	}

}
