package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {

	private boolean test;
	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag chooseTag = (ChooseTag) getParent();
		if(chooseTag.isFlag()&&test){
			getJspBody().invoke(null);
			chooseTag.setFlag(false);
		}
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
}
