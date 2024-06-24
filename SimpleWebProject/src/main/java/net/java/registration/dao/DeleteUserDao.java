package net.java.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import net.java.registration.db.DBUtil;
//import net.java.registration.model.User;

public class DeleteUserDao {
	
	public void deleteUser(int userID) throws ClassNotFoundException, SQLException {
        String DELETE_USER_SQL = "DELETE FROM user WHERE id=" + userID ;
        
        
        try (Connection connection = DBUtil.getConnection();

                // Step 2:Create a statement using connection object
                
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {       	
        		preparedStatement.executeUpdate();
                 
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                // process sql exception
            	System.out.println("There was an error: " + e);
            }               
    }

}
