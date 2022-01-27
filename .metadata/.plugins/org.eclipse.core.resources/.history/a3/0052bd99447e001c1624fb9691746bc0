package com.example.spring01.controller.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring01.model.board.dao.BoardDAO;
import com.example.spring01.model.board.dto.BoardVO;
 
@Service
public class BoardServiceImpl implements BoardService {
    
    @Inject
    BoardDAO boardDao;
    
    // 01. 게시글쓰기
    @Override
    public void create(BoardVO vo) throws Exception {
        String title = vo.getTitle();
        String content = vo.getContent();
        String writer = vo.getWriter();
        // *태그문자 처리 (< ==> &lt; > ==> &gt;)
        // replace(A, B) A를 B로 변경
        title = title.replace("<", "&lt;");
        title = title.replace("<", "&gt;");
        writer = writer.replace("<", "&lt;");
        writer = writer.replace("<", "&gt;");
        // *공백문자 처리
        title = title.replace("  ",    "&nbsp;&nbsp;");
        writer = writer.replace("  ",    "&nbsp;&nbsp;");
        // *줄바꿈 문자처리
        content = content.replace("\n", "<br>");
        vo.setTitle(title);
        vo.setContent(content);
        vo.setWriter(writer);
        boardDao.create(vo);
    }
    // 02. 게시글 상세보기
    @Override
    public BoardVO read(int bno) throws Exception {
        return boardDao.read(bno);
    }
    // 03. 게시글 수정
    @Override
    public void update(BoardVO vo) throws Exception {
        boardDao.update(vo);
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int bno) throws Exception {
        boardDao.delete(bno);
    }
    // 05. 게시글 전체 목록
    @Override
    public List<BoardVO> listAll() throws Exception {
        return boardDao.listAll();
    }
    public List<BoardVO> listAll(String searchOption, String keyword) throws Exception{
    	return boardDao.listAll(searchOption, keyword);
    }
    

    
	@Override
	public int countArticle(String searchOption, String keyword) {
		return boardDao.countArticle(searchOption, keyword);
	}
 
}