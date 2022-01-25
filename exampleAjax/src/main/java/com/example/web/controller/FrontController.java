package com.example.web.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.web.controller.board.InsertController;

import com.example.web.util.HttpUtil;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String charset = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doAction(req,res,"GET");
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doAction(req,res,"POST");
	}
	
	protected void doAction(HttpServletRequest req, HttpServletResponse res, String flag)throws ServletException, IOException{
		ServletConfig sc = this.getServletConfig();
		charset = sc.getInitParameter("charset");
		
		req.setAttribute("charset", charset);
		req.setCharacterEncoding(charset);
		res.setContentType("text/html; charset=" + charset);
		
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String command = uri.substring(conPath.length());
		
		Controller subController = null;
		
		if(command.equals("/board/insert.do") && flag.contentEquals("POST")) {
			System.out.println("insert");
			System.out.println("----------------------");
			subController = new InsertController();
			subController.execute(req, res);
		}else if(command.equals("/index.do")) {
			HttpUtil.forward(req, res, "/WEB-INF/views/index,jsp");
		}
	}

}
