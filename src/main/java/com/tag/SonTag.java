package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SonTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspTag parent = getParent();
		ParentTag parentTag = (ParentTag) parent;
		getJspContext().getOut().print("SonTag : "+parentTag.getName());
	}
}
