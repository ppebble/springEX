package com.edu.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class IndexController {

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("message","Hello spring MVC");
		
		return mv;
	}

}
