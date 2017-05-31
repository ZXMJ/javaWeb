package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class Mytag implements SimpleTag {

	private String name;

	private PageContext pageContext;

	@Override
	public void doTag() throws JspException, IOException {
		pageContext.getOut().print(name);
		System.out.println("name:" + name);
		System.out.println("doTag");
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}

	@Override
	public void setJspContext(JspContext arg0) {
		pageContext = (PageContext) arg0;
		System.out.println("setJspContext");
	}
	
	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
