package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Token
 */
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String hiddenCoke = request.getParameter("hiddenCoke");
		String sessionCoke = (String) session.getAttribute("sessionCoke");
		if(hiddenCoke.equals(sessionCoke)){
			System.out.println(request.getParameter("bookName"));
			session.removeAttribute("sessionCoke");
			response.sendRedirect(request.getContextPath()+"/token/success.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/token/repeate.jsp");
		}
	}*/
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = TokenProcessor.getInstance().isTokenValid(request);
		if(flag){
			TokenProcessor.getInstance().resetToken(request);
		}else{
			response.sendRedirect(request.getContextPath()+"/token/repeate.jsp");
			return;
		}
		System.out.println(request.getParameter("bookName"));
		response.sendRedirect(request.getContextPath()+"/token/success.jsp");
	}
}
