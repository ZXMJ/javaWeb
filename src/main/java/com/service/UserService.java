package com.service;

import java.util.List;

import com.pojo.SearchUser;
import com.pojo.User;

public interface UserService {
	
	void insert(User user) throws Exception;
	
	void delete(int id) throws Exception;
	
	void update(User user) throws Exception;
	
	long selectByName(String name) throws Exception;
	
	User selectById(String name) throws Exception;
	
	List<User> selectAllUser() throws Exception;
	
	List<User> selectUsers(SearchUser searchUser) throws Exception;
}
