package net.java.registration.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.java.registration.model.User;

public class DispayUserDao {
	
	public static List<User> getUserList (Connection conn) throws SQLException{
		
		String sqlQuery = "SELECT id, name, surname, gender, birthday, Home_Address, WorK_Address FROM user INNER JOIN home_address ON user.id=home_address.user_id INNER JOIN work_address ON user.id=work_address.user_id";
		
		PreparedStatement stm = conn.prepareStatement(sqlQuery);
		ResultSet rs = stm.executeQuery();
		
		List<User> list = new ArrayList<User>();
		
		while(rs.next()) {
			
			User user = new User();
			user.setId(Integer.parseInt(rs.getString("id")));
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));
			user.setGender(rs.getString("gender"));
			user.setBirthday(rs.getString("birthday"));
			user.setWorkAddress(rs.getString("WorK_Address"));
			user.setHomeAddress(rs.getString("Home_Address"));
			
			
			list.add(user);			
		}
		stm.close();
		rs.close();
		
		return list;
	}

}


