package com.example.spring01.controller.member;

import javax.servlet.http.HttpSession;

import com.example.spring01.model.member.dto.MemberVO;

public interface MemberService {
	public boolean loginCheck(MemberVO vo, HttpSession session);
	public MemberVO viewMember(MemberVO vo);
	public void logout(HttpSession session);

}
