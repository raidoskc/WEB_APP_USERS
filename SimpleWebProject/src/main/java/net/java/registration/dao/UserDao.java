package net.java.registration.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.java.registration.db.DBUtil;
import net.java.registration.model.User;


//To register a new user 
public class UserDao {

	 public int registerUser(User user) throws ClassNotFoundException, SQLException {
	        String INSERT_USERS_SQL = "INSERT INTO user" +
	            "  (id, name, surname, gender, birthday) VALUES " +
	            " (?, ?, ?, ?, ?);";
	        
	        String INSERT_HOME_SQL = "INSERT INTO home_address" +
		            "  (HomeID, Home_Address, user_id) VALUES " +
		            " (?, ?, ?);";
	        
	        String INSERT_WORK_SQL = "INSERT INTO work_address" +
		            "  (WorkID, Work_Address, user_id) VALUES " +
		            " (?, ?, ?);";

	        //Return user id
	        int result = 0;

	        //Class.forName("com.mysql.jdbc.Driver");
	        
	        try (Connection connection = DBUtil.getConnection();

	                //Create a statement using connection object
	                
	                PreparedStatement psQuery = connection.prepareStatement("select max(id)+1 from user");
	                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
	        		PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_HOME_SQL);
	        		PreparedStatement preparedStatement3 = connection.prepareStatement(INSERT_WORK_SQL)) {
	        	
	        		ResultSet rs = psQuery.executeQuery();
	        		
	        		//Take the max id from database=>users if exists or set id = 1
	        		int user_id = 1 ;
	        		if (rs.next() && rs.getString(1)!=null)
	        		{
	        			user_id = Integer.parseInt(rs.getString(1));
	        		}
	        		
	        		//Temporary data entry in the database 
	                preparedStatement.setInt(1, user_id);
	                preparedStatement.setString(2, user.getName());
	                preparedStatement.setString(3, user.getSurname());
	                preparedStatement.setString(4, user.getGender());
	                preparedStatement.setString(5, user.getBirthday());
	                
	                preparedStatement2.setInt(1, user_id);
	                preparedStatement2.setString(2, user.getHomeAddress());
	                preparedStatement2.setInt(3, user_id);
	                
	                preparedStatement3.setInt(1, user_id);
	                preparedStatement3.setString(2, user.getWorkAddress());
	                preparedStatement3.setInt(3, user_id);

	                
	                // Execute and update query
	                preparedStatement.executeUpdate();  
	                preparedStatement2.executeUpdate();  
	                preparedStatement3.executeUpdate();
	                
	                //Close all 
	                psQuery.close(); 
	                preparedStatement.close();
	                preparedStatement2.close();
	                preparedStatement3.close();
	                connection.close();

	                //Return id for User.java model => setId 
	                return user_id;
	                
	            } catch (SQLException e) {
	                // process sql exception
	                printSQLException(e);
	            }
	        
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	
}
