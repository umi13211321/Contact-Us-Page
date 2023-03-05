package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.models.User;

public class UserDao {
	
	public static boolean isAdmin(User user) {
		Connection connection = null;
		String dataBase = "ContactUs";
		String userName = "postgres";
		String passWord = "101010";
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dataBase, userName, passWord);
			if(connection != null) {
				System.out.println("Connection Established");
			}
			else {
				System.out.println("Connection Failed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Statement statement;
		ResultSet resultSet = null;
		String enteredUserName = user.getUserName();
		String enteredPassWord = user.getPassWord();
		String query = "SELECT * FROM adminInformation";
		boolean isValidCredential = false;
		
		try {
			statement = connection.createStatement();
        	resultSet = statement.executeQuery(query);
        	while(resultSet.next()) {
        		String adminUserName = resultSet.getString("username");
        		String adminPassWord = resultSet.getString("password");
        		if(enteredUserName.equals(adminUserName) && (enteredPassWord.equals(adminPassWord))) {
        			isValidCredential = true;
        			break;
        		}
        	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(isValidCredential) {
			return true;
		}
		else {
			return false;
		}
	}
}
