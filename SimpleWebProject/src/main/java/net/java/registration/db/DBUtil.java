package net.java.registration.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connected..");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleweb?useSSL=false", "root", "root");
		
	}

}
