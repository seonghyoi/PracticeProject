package com.spring.practice.board.service;

import java.util.List;

import com.spring.practice.board.model.dto.BoardDTO;
import com.spring.practice.board.model.dto.PageDTO;

public interface BoardService {

	List<BoardDTO> selectBoardList(PageDTO pageDTO) throws Exception;

	int selectCount() throws Exception;

	void insertBoard(BoardDTO boardDTO) throws Exception;

	BoardDTO boardDetail(int boardNo) throws Exception;

	void addViews(int boardNo) throws Exception;

	void deleteBoard(int boardNo) throws Exception;

}
