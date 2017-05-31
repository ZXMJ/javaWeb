package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyScopeListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {

	public MyScopeListener() {

	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed..." + sre.getServletRequest() + " " + sre.getSource());
	}
	
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized..." + sre.getServletRequest() + " " + sre.getSource());
	}

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated..." + se.getSession() + " " + se.getSource());
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed..." + se.getSession() + " " + se.getSource());
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized..." + sce.getServletContext() + " " + sce.getSource());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed..." + sce.getServletContext() + " " + sce.getSource());
	}

}
