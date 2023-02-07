package com.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class JdbcConnection {
	static MysqlConnectionPoolDataSource datasource=null;
	private JdbcConnection() {

	}

//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	// using connection pool
	static {
		
		 datasource=new MysqlConnectionPoolDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/crudproject1");
		datasource.setUser("root");
		datasource.setPassword("1234");
		
		
	}
	public static Connection getconnectionpool()  {
		Connection c=null;
		try {
			System.out.println(datasource);
			c=datasource.getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	public static Connection getConnection() {
		Connection c = null;
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/com/properties/jdbc.properties"));
			String url = p.getProperty("url");
			String name = p.getProperty("name");
			String password = p.getProperty("password");

			c = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}
}
