package com.filter;

import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter extends HttpFilter {

	private String redirectUrl;
	private String sessionKey;
	private String url;
	private List<String> urlList;

	@Override
	public void init() {
		sessionKey = getFilterConfig().getServletContext().getInitParameter("sessionKey");
		redirectUrl = getFilterConfig().getServletContext().getInitParameter("redirectUrl");
		url = getFilterConfig().getServletContext().getInitParameter("url");
		urlList = Arrays.asList(url.split(","));
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		//	http://localhost:8888/webMavenTest/login/a.jsp
		//String Url = request.getRequestURL().toString();
		//	/webMavenTest/login/a.jsp
		//String uri = request.getRequestURI();
		//	/login/a.jsp
		String path = request.getServletPath();
		//	E:\pasmWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp5\wtpwebapps\webMavenTest\login\a.jsp
//		String realPath = request.getRealPath(path);
		//	/webMavenTest
		String contextPath = request.getContextPath();
//		System.out.println("Url: "+Url);
//		System.out.println("uri: "+uri);
//		System.out.println("path: "+path);
//		System.out.println("realPath: "+realPath);
//		System.out.println("contextPath: "+contextPath);
		HttpSession session = request.getSession();
		String name = request.getParameter("username");
		if(name!=null&&!"".equals(name.trim())){
			session.setAttribute(sessionKey, name);
		}
		
		if (urlList != null && urlList.contains(path)) {
			try {
				chain.doFilter(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		String username = (String) session.getAttribute(sessionKey);
		if (username == null || "".equals(username.trim())) {
			try {
				response.sendRedirect(contextPath+redirectUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
