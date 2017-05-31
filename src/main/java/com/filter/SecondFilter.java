package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class SecondFilter
 */
public class SecondFilter implements Filter {

    public SecondFilter() {
    }

	public void destroy() {
		System.out.println("secondFilter destory ...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("secondFilter before chain ...");
		chain.doFilter(request, response);
		System.out.println("secondFilter after chain ...");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("secondFilter init ...");
	}

}
