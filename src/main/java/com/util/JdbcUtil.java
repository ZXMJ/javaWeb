package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	/**
	 * @Description: 传统方式获取数据库连接连接
	 *
	 * @date 2016年8月31日,下午4:08:45
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param con
	 * @param ps
	 * @param rs
	 */
	private static String driverClass = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	
	static{
		
		Properties info = new Properties();
		InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
		
		try {
			info.load(is);
			driverClass = info.getProperty("driverClass");
			url = info.getProperty("url");
			user = info.getProperty("user");
			password = info.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		
		Connection con=null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
//	private static DataSource dataSource;
	/**
	 * 
	 * @Description: 通过c3p0获取数据库连接
	 *
	 * @date 2016年8月31日,下午4:09:05
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param con
	 * @param ps
	 * @param rs
	 */
	/*static{
		dataSource = new ComboPooledDataSource("c3p0");
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}*/
	/*static{
		try {
			Properties info = new Properties();
			InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
			info.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}*/
	public static void close(Connection con,PreparedStatement ps,ResultSet rs){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
