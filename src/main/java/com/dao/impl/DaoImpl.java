package com.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.Dao;

public class DaoImpl<T, E> implements Dao<T, E> {

	private QueryRunner qr = null;
	private Class<T> clazzT = null;
	
	public DaoImpl() {
		qr = new QueryRunner();
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) type;
			Type[] types = pType.getActualTypeArguments();
			clazzT = (Class<T>) types[0];
		}else{
			clazzT = (Class<T>) Object.class;
		}
		
	}

	@Override
	public void batch(Connection con, String sql, Object[]... args)
			throws Exception {
		for(Object[] arg:args){
			qr.update(con, sql, arg);
		}
	}

	@Override
	public E getScalr(Connection con, String sql, Object... args)
			throws Exception {
		return qr.query(con, sql, new ScalarHandler<E>(), args);
	}

	@Override
	public List<T> getBeanList(Connection con, String sql, Object... args)
			throws Exception {
		return qr.query(con, sql, new BeanListHandler<T>(clazzT), args);
	}

	@Override
	public T getBean(Connection con, String sql, Object... args)
			throws Exception {
		return qr.query(con, sql, new BeanHandler<T>(clazzT),args);
	}

	@Override
	public void update(Connection con, String sql, Object... args)
			throws Exception {
		qr.update(con, sql, args);
	}

	@Override
	public void insert(Connection con, String sql, Object... args)
			throws Exception {
		qr.insert(con, sql, new BeanHandler<T>(clazzT), args);
	}

}
