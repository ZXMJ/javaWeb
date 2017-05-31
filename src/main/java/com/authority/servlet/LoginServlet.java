package com.authority.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.authority.dao.Dao;
import com.authority.dao.impl.DaoImpl;
import com.authority.pojo.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private Dao userdao = new DaoImpl();
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		User user = userdao.get(username);
		request.getSession().setAttribute("user", user);
//		request.getSession().setAttribute("authoriyList", user.getAuthorityList());
		response.sendRedirect(request.getContextPath()+"/authority/authorityList.jsp");
		return ;
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/authority/login.jsp");
		return ;
	}
}
