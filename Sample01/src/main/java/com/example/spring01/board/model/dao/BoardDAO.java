package com.example.spring01.board.model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.board.model.dto.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public void increaseViewcnt(int bno) throws Exception;

	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword);

	public int countArticle(String searchOption, String keyword);

}
