package com.spring.practice.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.practice.board.model.dto.BoardDTO;
import com.spring.practice.board.model.dto.PageDTO;

@Repository
public class BoardDAO {

	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession, PageDTO pageDTO) {
		
		return sqlSession.selectList("boardMapper.selectBoardList", pageDTO);
	
	}

	
	public int selectCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectCount");
		
	}


	public void insertBoard(SqlSessionTemplate sqlSession, BoardDTO boardDTO) {
		
		sqlSession.insert("boardMapper.insertBoard", boardDTO);
		
	}


	public BoardDTO boardDetail(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
		
	}


	public int addViews(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.update("boardMapper.updateViews", boardNo);
		
	}

}
