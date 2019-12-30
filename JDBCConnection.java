package main.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	private static Connection con = null;
	private JDBCConnection() {
	}
	static {
		try {
			Class.forName("org.postgresql.Driver");			// database driver
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "postgres");		//	url:port/dbname,host,password
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		return con;
	}
}
