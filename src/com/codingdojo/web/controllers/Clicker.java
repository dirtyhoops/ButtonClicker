package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Clicker
 */
@WebServlet("/index")
public class Clicker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String count = (String) session.getAttribute("count");
		Integer number;
		if(count == null) {
			session.setAttribute("count", "0");
		} else {
			number = Integer.parseInt(count);
			number += 1;
			count = number.toString();
			session.setAttribute("count", count);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
