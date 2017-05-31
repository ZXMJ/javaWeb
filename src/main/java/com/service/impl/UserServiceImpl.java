package com.service.impl;

import java.sql.Connection;
import java.util.List;

import com.dao.impl.DaoImpl;
import com.pojo.SearchUser;
import com.pojo.User;
import com.service.UserService;
import com.util.JdbcUtil;

public class UserServiceImpl extends DaoImpl<User, Long> implements UserService {

	private Connection con;

	private String sql;

	@Override
	public void insert(User user) throws Exception {
		con = JdbcUtil.getConnection();
		sql = "insert into user (name,email,birth) values (?,?,?)";
		insert(con, sql, user.getName(),user.getEmail(),user.getBirth());
	}

	@Override
	public void delete(int id) throws Exception {
		con = JdbcUtil.getConnection();
		sql = "delete from user where id = ?";
		update(con, sql, id);
	}

	@Override
	public void update(User user) throws Exception {
		con = JdbcUtil.getConnection();
		sql = "update user set name = ?,email = ?,birth = ? where id = ?";
		update(con, sql, user.getName(),user.getEmail(),user.getBirth(),user.getId());
	}

	@Override
	public long selectByName(String name) throws Exception {
		con = JdbcUtil.getConnection();
		sql = "select count(name) from user where name = ?";
		return getScalr(con, sql, name);
	}

	@Override
	public List<User> selectAllUser() throws Exception {
		con = JdbcUtil.getConnection();
		sql = "select id,name,email,birth from user";
		List<User> users = getBeanList(con, sql);
		return users;
	}

	@Override
	public List<User> selectUsers(SearchUser searchUser) throws Exception {
		con = JdbcUtil.getConnection();
		sql = "select id,name,email,birth from user where name like ? and email like ?";
		List<User> users = getBeanList(con, sql,searchUser.getName(),searchUser.getEmail());
		return users;
	}

	@Override
	public User selectById(String id) throws Exception {
		con = JdbcUtil.getConnection();
		sql = "select id,name,email,birth from user where id = ?";
		User user= getBean(con, sql, id);
		return user;
	}
}
