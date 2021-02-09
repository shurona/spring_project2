package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		String seq = request.getParameter("seq");

		//2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
//		System.out.println(vo);
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
//		return "getBoard";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);
		mav.setViewName("getBoard");
		
		return mav;
	}

}
