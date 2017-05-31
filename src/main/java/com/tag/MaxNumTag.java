package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MaxNumTag implements SimpleTag {

	private String num1;
	private String num2;
	private JspContext jspContext;
	@Override
	public void doTag() throws JspException, IOException {
		jspContext.getOut().print(Integer.parseInt(num1)>Integer.parseInt(num2)?num1+">"+num2:num2+">="+num1);
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
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

}
