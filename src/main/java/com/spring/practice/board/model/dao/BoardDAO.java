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

}
