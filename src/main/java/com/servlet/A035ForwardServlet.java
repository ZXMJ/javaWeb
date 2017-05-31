package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A035ForwardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("ForwardServlet's doGet...");
		req.setAttribute("request", "forwardValue");
		//重定向：/代表的是当前WEB站点的根目录
		//转	  发： /代表的是当前WEB应用的根目录
		//转发到jsp
		req.getRequestDispatcher("A25.jsp").forward(req, resp);
		//转发到servlet
//		req.getRequestDispatcher("second").forward(req, resp);
	}
}
