package com.tag;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {

	private Object items;
	private String var;

	@Override
	public void doTag() throws JspException, IOException {
		if (items instanceof Map<?, ?>) {
			for (Entry<?, ?> entry : ((Map<?, ?>) items).entrySet()) {
				((PageContext) getJspContext()).setAttribute(var, entry);
				getJspBody().invoke(null);
			}
		} else if (items instanceof Collection<?>) {
			for (Object obj : (Collection<?>) items) {
				((PageContext) getJspContext()).setAttribute(var, obj);
				getJspBody().invoke(null);
			}
		}

	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Object getItems() {
		return items;
	}

	public void setItems(Object items) {
		this.items = items;
	}
}
