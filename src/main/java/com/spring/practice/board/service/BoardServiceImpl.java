package com.spring.practice.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.board.model.dao.BoardDAO;
import com.spring.practice.board.model.dto.BoardDTO;
import com.spring.practice.board.model.dto.PageDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final BoardDAO boardDAO;
	//--------------------------------------------------------- // @Autowired 생략 가능
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO; 
	}
	
	
	@Override
	public List<BoardDTO> selectBoardList(PageDTO pageDTO) throws Exception {
		
		return boardDAO.selectBoardList(sqlSession, pageDTO);
	
	}
	
	
	@Override
	public int selectCount() throws Exception {

		return boardDAO.selectCount(sqlSession);

	}


	@Override
	public void insertBoard(BoardDTO boardDTO) throws Exception {
		
		boardDAO.insertBoard(sqlSession, boardDTO);
		
	}


	@Override
	public BoardDTO boardDetail(int boardNo) throws Exception {
		
		return boardDAO.boardDetail(sqlSession, boardNo);
		
	}


	@Override
	public void addViews(int boardNo) throws Exception {
		
		System.out.println("addViews 실행됨!!!!!!!!!!!");
		
		boardDAO.addViews(sqlSession, boardNo);
		
	}


	@Override
	public void deleteBoard(int boardNo) throws Exception {
		
		boardDAO.deleteBoard(sqlSession, boardNo);
		
	}


}
