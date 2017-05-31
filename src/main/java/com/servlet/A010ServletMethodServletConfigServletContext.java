package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class A010ServletMethodServletConfigServletContext implements Servlet {

	@Override
	public void destroy() {
		System.out.println("destory...");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo...");
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

		/**
		 * 获取该servlet的初始化参数 ①根据名字获取②获取所有的，后遍历
		 */
		String firstValue = servletConfig.getInitParameter("user");
		String secondValue = servletConfig.getInitParameter("password");
		System.out.println("firstValue：" + firstValue + "  secondValue："
				+ secondValue);

		Enumeration<String> names = servletConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = servletConfig.getInitParameter(name);
			System.out.println("name^^：" + name + "  value^^：" + value);
		}
		/**
		 * 获取web.xml.中该servlet的servlet-name
		 */
		String servletName = servletConfig.getServletName();
		System.out.println("servletName：" + servletName);

		/**
		 * 获取整个web项目的servlet信息
		 */
		ServletContext servletContext = servletConfig.getServletContext();
		/**
		 * 获取全局的servlet的初始化参数 ①根据名字获取②获取所有的，后遍历
		 */
		String driver = servletContext.getInitParameter("driver");
		String url = servletContext.getInitParameter("url");
		System.out.println("driver^^: " + driver + " url^^:" + url);

		Enumeration<String> names2 = servletContext.getInitParameterNames();
		while (names2.hasMoreElements()) {
			String name = names2.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println(name + " : " + value);
		}

		/**
		 * 获取资源文件的输入流
		 */
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
		System.out.println(inputStream);
		/**
		 * 通过classLoader
		 */
		InputStream inputStream2 = servletContext.getClassLoader().getResourceAsStream("db.properties");
		System.out.println(inputStream2);
		
		/**
		 * 文件在部署的服务器上的路径(路径不对，少了/WEB-INF/classes)
		 */
		String realPath = servletContext.getRealPath("db.properties");
		System.out.println(realPath);
		
		/**
		 * 该项目的域名，即content root
		 */
		String path = servletContext.getContextPath();
		System.out.println(path);
		
		System.out.println("init...");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service...");
	}

	public A010ServletMethodServletConfigServletContext() {
		System.out.println("ServletTest...");
	}
}
