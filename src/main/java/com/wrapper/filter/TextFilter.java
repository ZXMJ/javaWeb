package com.wrapper.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.filter.HttpFilter;

/**
 * Servlet Filter implementation class TextFilter
 */
public class TextFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		MyHttpServletRequest req = new MyHttpServletRequest(request);
		chain.doFilter(req, response);
	}

}
