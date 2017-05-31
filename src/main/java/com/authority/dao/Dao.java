package com.authority.dao;

import com.authority.pojo.User;

public interface Dao {

	User get(String username);
	
	void update(User user);
}
