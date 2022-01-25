package com.example.spring01.model.member.dao;

import javax.servlet.http.HttpSession;

import com.example.spring01.model.member.dto.MemberVO;

public interface MemberDAO {
	public boolean loginCheck(MemberVO vo);
	public MemberVO viewMember(MemberVO vo);
	public void logout(HttpSession session);

}
