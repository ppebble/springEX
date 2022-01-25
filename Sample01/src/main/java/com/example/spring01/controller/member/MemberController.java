//package com.example.spring01.controller.member;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.example.spring01.model.member.dto.MemberVO;
//
//@Controller
//@RequestMapping("/member/*")
//public class MemberController {
//	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
//	
//	@Inject
//	MemberService memberService;
//	
//	@RequestMapping("login.do")
//	public String login() {
//		return "member/login";
//	}
//	
//	@RequestMapping("loginCheck.do")
//	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
//		boolean result = memberService.loginCheck(vo, session);
//		ModelAndView mav = new ModelAndView();
//	}
//
//}
