package com.pojo;


import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * HttpSessionBindingListener:监听User对象在session中的绑定与解绑
 * HttpSessionActivationListener:监听session中的user在硬盘钝化与活化(在线用户数统计)
 */
public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable{

	private static final long serialVersionUID = -5728247373208105375L;
	private String id;
	private String name;
	private String email;
	private String birth;
	
	public User() {
		
	}

	public User(String name, String email, String birth) {
		this.name = name;
		this.email = email;
		this.birth = birth;
	}

	public User(String id, String name, String email, String birth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("----------------------");
		System.out.println("User valueBound: " + event.getName() + " " + event.getValue());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("User valueUnbound: " + event.getName() + " " + event.getValue());
		System.out.println("----------------------");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("----------***------------");
		System.out.println("User sessionWillPassivate: " + se.getSession());
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("User sessionDidActivate: " + se.getSession());
		System.out.println("----------***------------");
	}
}
