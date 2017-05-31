package com.authority.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.authority.dao.Dao;
import com.authority.pojo.Authority;
import com.authority.pojo.User;

public class DaoImpl implements Dao{
	
	private static Map<String,User> userMap;
	private static List<Authority> authoriyList;
	
	static{
		authoriyList = new ArrayList<Authority>(); 
		authoriyList.add(new Authority("A001","/authority/A001.jsp"));
		authoriyList.add(new Authority("A002","/authority/A002.jsp"));
		authoriyList.add(new Authority("A003","/authority/A003.jsp"));
		authoriyList.add(new Authority("A004","/authority/A004.jsp"));
		User user1 = new User("aa",authoriyList.subList(0, 2));
		User user2 = new User("bb",authoriyList.subList(2, 4));
		userMap = new HashMap<String,User>();
		userMap.put("aa", user1);
		userMap.put("bb", user2);
	}	
	@Override
	public User get(String username) {
		return userMap.get(username);
	}

	@Override
	public void update(User user) {
		
	}
	public static List<Authority> getAuthorityList() {
		return authoriyList;
	}

}
