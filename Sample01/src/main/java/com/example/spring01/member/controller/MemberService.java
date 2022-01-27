package com.example.spring01.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.member.model.dto.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public MemberVO viewMember(String userId);
	public void deleteMember(String userId);
	public void updateMember(MemberVO vo);
	public boolean loginCheck(MemberVO vo);
	public boolean checkPw(String userId, String userPw);
	
	
	public boolean loginCheck(MemberVO vo, HttpSession session);
	public MemberVO viewMember(MemberVO vo);
	public void logout(HttpSession session);
}
