package com.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagBodyTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jspBody = getJspBody();
//		StringWriter sw = new StringWriter();
		//参数为空时，直接把jspBody中的内容输出到页面
		jspBody.invoke(null);
//		jspBody.invoke(sw);
//		System.out.println(sw.toString());
//		getJspContext().getOut().print(sw.toString());
	}
}
