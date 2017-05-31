package com.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class A015Servlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("SecondServlet destory...");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("SecondServlet getServletConfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("SecondServlet getServletInfo...");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("SecondServlet init...");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("SecondServlet service...");
	}

	public A015Servlet() {
		System.out.println("SecondServlet ...");
	}
}
