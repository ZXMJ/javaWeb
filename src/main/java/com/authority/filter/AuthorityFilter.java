package com.authority.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.authority.dao.Dao;
import com.authority.dao.impl.DaoImpl;
import com.authority.pojo.Authority;
import com.authority.pojo.User;
import com.filter.HttpFilter;

public class AuthorityFilter extends HttpFilter{

	private Dao dao = new DaoImpl();
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String path = request.getServletPath();
		List<String> uncheckUrls = Arrays.asList("/authority/authority-manager.jsp","/authority/authorityList.jsp","/authority/loginServlet","/authority/login.jsp","/authority/authorityServlet","/authority/checkAuthority.jsp","/authority/noAuthority.jsp");
		if(uncheckUrls.contains(path)){
			chain.doFilter(request, response);
			return;
		}
		User user = null;
		String username = request.getParameter("username");
		if(username!=null){
			user = dao.get(username);
		}else{
			user = (User) request.getSession().getAttribute("user");
		}
		List<Authority> authorities = user.getAuthorities();
		Authority authority = new Authority(null, path);
		if(authorities.contains(authority)){
			chain.doFilter(request, response);
			return;
		}
		response.sendRedirect(request.getContextPath()+"/authority/noAuthority.jsp");
		return;
	}
}
