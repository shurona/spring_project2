package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring{
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//sql 명령어
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content)"+
							"values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_LIST_T = "select * from where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from where content like '%'||?||'%' order by seq desc";
	
//	@Autowired
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC Spring으로 INSERTBOARD() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC Spring으로 UPDATEBOARD() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(),vo.getContent(),vo.getSeq());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC Spring으로 DELETEBOARD() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC Spring으로 GETBOARD() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC Spring으로 GETBOARDList() 기능 처리");
//		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		Object[] args = {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		return null;
	}
	
	
	
}
