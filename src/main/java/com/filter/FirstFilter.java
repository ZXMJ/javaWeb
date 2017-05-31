package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FirstFilter
 */
public class FirstFilter implements Filter {

	private FilterConfig filterConfig;
    public FirstFilter() {
    }

	public void destroy() {
		System.out.println("firstFilter destory...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String filterInit = filterConfig.getInitParameter("filterInit");
		System.out.println("filterInit: "+filterInit);
		String serverInit = filterConfig.getServletContext().getInitParameter("serverInit");
		System.out.println("serverInit: "+serverInit);
		
		System.out.println("firstFilter before chain ...");
		chain.doFilter(request, response);
		System.out.println("firstfilter after chain ...");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig=fConfig;
		System.out.println("firstFilter init ...");
	}

}
