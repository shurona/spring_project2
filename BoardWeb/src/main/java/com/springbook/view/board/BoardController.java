package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/deleteBoard.co")
	public String deleteBoard(BoardVO vo){
	
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/getBoard.do")
	public String handleRequest(BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");

//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board",boardDAO.getBoard(vo));
//		mav.setViewName("getBoard.jsp");
		
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model){
		System.out.println("글 목록 검색 처리");
		
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("boardList", boardDAO.getBoardList(vo));
//		mav.setViewName("getBoardList.jsp");
		//view와 model을 구분한다. 
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	//Service를 사용하지 않고 Mapping
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//							   @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
//								BoardVO vo, BoardDAO boardDAO, Model model){
//		System.out.println("글 목록 검색 처리");
//		System.out.println("검색 조건 : " + condition);
//		System.out.println("검색 단어 : " + keyword);
////		ModelAndView mav = new ModelAndView();
////		mav.addObject("boardList", boardDAO.getBoardList(vo));
////		mav.setViewName("getBoardList.jsp");
//		//view와 model을 구분한다. 
//		model.addAttribute("boardList", boardDAO.getBoardList(vo));
//		return "getBoardList.jsp";
//	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		System.out.println("글 등록 처리");
		
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/"+fileName));
		}
		
//		System.out.println(vo);
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	

	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo){
		System.out.println("글 수정 처리");
		System.out.println("번호 : "+vo.getSeq());
		System.out.println("제목 : "+vo.getTitle());
		System.out.println("작성자 : "+ vo.getWriter());
		System.out.println("내용 : "+vo.getContent());
		System.out.println("등록일 : "+vo.getRegDate());
		System.out.println("조회수 : "+vo.getCnt());
//		boardDAO.updateBoard(vo);
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

}
