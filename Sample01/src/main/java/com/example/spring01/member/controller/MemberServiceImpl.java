package com.example.spring01.member.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring01.member.model.dao.MemberDAOImpl;
import com.example.spring01.member.model.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAOImpl memberDao;

	// 전체 회원 리스트 조회
	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return memberDao.memberList();
	}

	// 회원 가입
	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);

	}

	// 회원 상세 정보 조회
	@Override
	public MemberVO viewMember(String userId) {
		// TODO Auto-generated method stub
		return memberDao.viewMember(userId);
	}

	// 회원 정보 삭제
	@Override
	public void deleteMember(String userId) {
		memberDao.deleteMember(userId);

	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDao.updateMember(vo);

	}

	@Override
	public boolean loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();

	}

	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		boolean result = memberDao.loginCheck(vo);
		if(result) {
			MemberVO vo2 = viewMember(vo);
			
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getUserName());
		}
		return result;
	}
	//수정 및 삭제를 위한 비밀번호 체크 서비스
	@Override
	public boolean checkPw(String userId, String userPw) {
		// TODO Auto-generated method stub
		return memberDao.checkPw(userId, userPw);
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		return memberDao.viewMember(vo);
	}

}
