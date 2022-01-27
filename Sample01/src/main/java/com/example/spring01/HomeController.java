package com.example.spring01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String main(Model model) {
		//model :: 데이터를 담는 공간(map구조)
		//model.addAttribute("변수명", 값);
		model.addAttribute("msg", "홈페이지 방문을 환영합니다");
		return "main";
	}
	
	//url mapping
	@RequestMapping(value="home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! Client Locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		//home.jsp로 포워딩
		//servlet-context.xml :: 
		//<beans:property name = "prefix" value = "/WEB-INF/views/" />
		//  	"		suffix = ".jsp"
		
		return "home";
	}
	
}
