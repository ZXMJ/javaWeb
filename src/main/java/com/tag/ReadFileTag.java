package com.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class ReadFileTag implements SimpleTag {

	private String src;
	private JspContext jspContext;

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		InputStream in = pageContext.getServletContext().getResourceAsStream(src);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		String str = null;
		while ((str = reader.readLine()) != null) {

			str = Pattern.compile("<").matcher(str).replaceAll("&lt");
			str = Pattern.compile(">").matcher(str).replaceAll("&gt");

			pageContext.getOut().println(str);
			pageContext.getOut().println("<br>");
		}
	}

	private JspContext getJspContext() {
		return jspContext;
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setJspContext(JspContext arg0) {
		jspContext = arg0;
	}

	@Override
	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub

	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
