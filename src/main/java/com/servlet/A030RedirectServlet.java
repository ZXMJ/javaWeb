package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A030RedirectServlet extends HttpServlet {
	
	private static final long serialVersionUID = -4532325154337498644L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("RedirectServlet's doGet()...");
		req.setAttribute("request", "redirectValue");
		//重定向：/代表的是当前WEB站点的根目录
		//转	  发： /代表的是当前WEB应用的根目录
		//重定向到jsp
		resp.sendRedirect("A25.jsp");
		//重定向到servlet
//		resp.sendRedirect("second");
	}
}
