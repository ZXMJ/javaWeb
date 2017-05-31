package com.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MyAttributeListener
 *
 */
public class MyAttributeListener
		implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

	public MyAttributeListener() {
	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("RequestAttributeAdded: " + srae.getName() + " " + srae.getValue() + " " + srae.getSource());
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("RequestAttributeReplaced: " + srae.getName() + " " + srae.getValue() + " " + srae.getSource());
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("RequestAttributeRemoved: " + srae.getName() + " " + srae.getValue() + " " + srae.getSource());
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionAttributeAdded: " + event.getName() + " " + event.getValue() + " " + event.getSource());
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionAttributeReplaced: " + event.getName() + " " + event.getValue() + " " + event.getSource());
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionAttributeRemoved: " + event.getName() + " " + event.getValue() + " " + event.getSource());
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("ServletContextAttributeAdded: " + event.getName() + " " + event.getValue() + " " + event.getSource());
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("ServletContextAttributeReplaced: " + event.getName() + " " + event.getValue() + " " + event.getSource());
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("ServletContextAttributeRemoved: " + event.getName() + " " + event.getValue() + " " + event.getSource());
	}

}
