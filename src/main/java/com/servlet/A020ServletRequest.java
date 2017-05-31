package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A020ServletRequest implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		/**
		 * 根据名字获取前台传过来的值
		 */
		String user = req.getParameter("user");
		String pswd = req.getParameter("pswd");
		System.out.println("user: " + user + " pswd： " + pswd);

		/**
		 * 根据名字获取一个String类型的数组(例如checkbox)
		 */
		String[] hobbys = req.getParameterValues("hobby");
		for (String hobby : hobbys) {
			System.out.println(hobby);
		}

		/**
		 * 获取前台传过来的所有的参数的名字
		 */
		Enumeration<String> enums = req.getParameterNames();
		while (enums.hasMoreElements()) {
			String name = enums.nextElement();
			String value = req.getParameter(name);
			System.out.println("name: " + name + " value： " + value);
		}

		/**
		 * 获取前台传过来的所有参数的name和value的map
		 */
		Map<String, String[]> map = req.getParameterMap();
		for (Entry<String, String[]> entry : map.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			System.out.println("key: " + key + " values: " + Arrays.asList(values));
		}

		HttpServletRequest request = (HttpServletRequest) req;
		// uri=contextPath+servletPath /javaWeb/login
		String uri = request.getRequestURI();
		System.out.println(uri);
		// /javaWeb
		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		// /login
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		// url= http://ip:port/contextPath/servletPath url=http://ip:port
		// http://localhost:8888/javaWeb/login
		String url = request.getRequestURL().toString();
		System.out.println(url);

		/**
		 * 获取form表单请求的方式，当为get方法是QueryString有值，是参数串；post方法时，QueryString为空
		 */
		String method = request.getMethod();
		System.out.println(method);
		String query = request.getQueryString();
		System.out.println(query);

		HttpServletResponse response = (HttpServletResponse) res;
		PrintWriter out = response.getWriter();
		out.print("");// 方法，可以输出一个java对象；
		out.write("");// 方法，只能输入一个字符串。
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
