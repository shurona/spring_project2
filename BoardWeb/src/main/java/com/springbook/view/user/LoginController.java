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
		System.out.println("�α��� ó��!");
		//���̵�� �н����带 request�� �޾Ƽ�
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		//�̰��� UserVO��ü�� ���� ���� �̿� �ش��ϴ� DB�� �������� �޾ƿ´�. 

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		//�ش� �������� �����ϸ� �α��� �ƴϸ� �α��� ȭ�� ����
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
