package com.example.spring01.member.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.member.model.dto.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	
	
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		//controller => service => dao
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list",list);
		return "member/member_list";
	}
	// 2 member Register Page
	@RequestMapping("member/write.do")
	public String memberWrite() {
		return "member/member_write";
	}
	//회원 가입 후 목록으로 redirect
	@RequestMapping("member/insert.do")
	//폼에서 입력한 데이터를 읽어들이는 방법
	/*
	 * 1. public String memberInsert(HttpServlet req){ ...}
	 * 2. public String memberInsert(String userId, String userPw ..){ }
	 */
	public String memberInsert(@ModelAttribute MemberVO vo) {
		memberService.insertMember(vo);
		/*
		 *   '/' 유무 차이
		 *   /member/list.do : root dir 기준
		 *   member/list.do : 현재 dir 기준
		 *   member_list.jsp 해당 dir
		 */
		return "redirect:/member/list.do";
	}
	
	// 3 상세정보 조회
	@RequestMapping("member/view.do")
	public String MemberView(String userId, Model model) {
		model.addAttribute("dto", memberService.viewMember(userId));
		logger.info("클릭한 아이디 : " + userId);
		return "member/member_view";//member_view.jsp forward
	}
	// 4 정보 수정 반영하기
	@RequestMapping("member/update.do")
	public String memberUpdate(@ModelAttribute MemberVO vo, Model model) {
		boolean result = memberService.checkPw(vo.getUserId(), vo.getUserPw());
		if(result) {
			memberService.updateMember(vo);
			return "redirect:/member/list.do";
		} else {
			MemberVO vo2 = memberService.viewMember(vo.getUserId());
			vo.setUserRegdate(vo2.getUserRegdate());
			model.addAttribute("dto", vo);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다");
			return "member/member_view";
			
		}

		
	}
	//5 정보 삭제 처리
	@RequestMapping("member/delete.do")
	public String memberDelete(@RequestParam String userId, @RequestParam String userPw, Model model) {
		boolean result = memberService.checkPw(userId, userPw);
		if(result) {
			memberService.deleteMember(userId);
			return "redirect:/member/list.do";
		}
		else {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto", memberService.viewMember(userId));
			return "member/member_view";
		}
	}
	
	// ------------------로그인
	//6 로그인 화면
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	//7 로그인 처리
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if(result == true) {
			mav.setViewName("main");
			mav.addObject("msg","success");
		} else {
			mav.setViewName("member/login");
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	//8 로그아웃 처리
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg", "logout");
		return mav;
	}

}
