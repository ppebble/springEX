package com.example.spring01.member.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.member.model.dto.MemberVO;

@Repository //DAOImpl을 DAO bean으로 등록
public class MemberDAOImpl implements MemberDAO {
	
	/*
	 * SqlSession 객체를 스프링에서 생성하여 주입
	 * 의존관계 주입(DI)
	 * 느슨한 결함
	 * 제어의 역전
	 */
	@Inject
	SqlSession sqlSession;
	/*
	 * Inject 어노테이션이 없으면 sqlSession = null
	 * 있으면 외부에서 객체를 주입시켜주게된다
	 * try catch, finally에서 객체를 닫을 필요 X
	 */
	
	
	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberVO viewMember(String userId) {
		return sqlSession.selectOne("member.viewMember", userId);
	}

	

	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
		
	}

	@Override
	public void deleteMember(String userId) {
		sqlSession.delete("member.deleteMember", userId);
		
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("member.updateMember", vo);
		
	}

	public boolean checkPw(String userId, String userPw) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		int count = sqlSession.selectOne("member.checkPw", map);
		if(count == 1) result = true;
		return result;
	}
	@Override
	public boolean loginCheck(MemberVO vo) {
		String name = sqlSession.selectOne("member.loginCheck", vo);
		return (name==null) ? false : true;
	}
	

	@Override
	public MemberVO viewMember(MemberVO vo) {
		return sqlSession.selectOne("member.viewMember",vo);
	}
	@Override
	public void logout(HttpSession session) {
	}

}
