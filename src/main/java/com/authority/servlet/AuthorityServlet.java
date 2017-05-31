package com.authority.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.authority.dao.Dao;
import com.authority.dao.impl.DaoImpl;
import com.authority.pojo.Authority;
import com.authority.pojo.User;

public class AuthorityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Dao userDao = new DaoImpl();

	public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		request.setAttribute("user", userDao.get(username));
		request.setAttribute("authorityList", DaoImpl.getAuthorityList());
		request.getRequestDispatcher("/authority/authority-manager.jsp").forward(request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		User user = userDao.get(username);
		String[] authorities = request.getParameterValues("authority");
		List<Authority> authorityList = new ArrayList<Authority>();
		if (authorities != null && authorities.length > 0) {
			for(String auth : authorities){
				authorityList.add(new Authority(auth.substring(11,15),auth));
			}
		}
		user.setAuthorities(authorityList);
		response.sendRedirect(request.getContextPath()+"/authority/checkAuthority.jsp");
	}
}
