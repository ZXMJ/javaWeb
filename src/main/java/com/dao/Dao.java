package com.dao;

import java.sql.Connection;
import java.util.List;

public interface Dao<T,E> {

	void batch(Connection con,String sql,Object[] ...args) throws Exception;
	
	E getScalr(Connection con,String sql,Object ...args) throws Exception;
	
	List<T> getBeanList(Connection con,String sql,Object ...args) throws Exception;
	
	T getBean(Connection con,String sql,Object ...args) throws Exception;
	
	void update(Connection con,String sql,Object ...args) throws Exception;
	
	void insert(Connection con,String sql,Object ...args) throws Exception;
}
