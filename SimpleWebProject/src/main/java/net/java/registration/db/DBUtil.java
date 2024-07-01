package net.java.registration.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBUtil {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		List<String> everything = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("../git/repository/SimpleWebProject/DBInfo.txt"));
		    String line = br.readLine();

		    while (line != null) {
		        everything.add(line);
		        line = br.readLine();
		    }
		} catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connected..");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + everything.get(0) + "?useSSL=false", everything.get(1), everything.get(2));
		
	}

}
