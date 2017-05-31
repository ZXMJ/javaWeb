package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class A037DomainObject extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		Object reqValue = req.getAttribute("request");
		out.print(reqValue);
		out.print("\r\n");
		
		HttpSession session = req.getSession();
		Object sesValue = session.getAttribute("session");
		out.print(sesValue);
		out.print("\r\n");
		
		Object appValue = getServletContext().getAttribute("application");
		out.print(appValue);
		out.print("\r\n");
		
	}
}
