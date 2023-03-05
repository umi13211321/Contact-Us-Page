package com.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.models.Request;

public class RequestDao {
	
	public static void saveRequest(Request user) {
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
			System.out.println("Connection Failed");
		}
		
		Statement statement;
		String name = user.getName();
		String email = user.getEmail();
		String message = user.getMessage();
		String query = "INSERT INTO userinformation (name, email, message) VALUES ( '"+name+"', '"+email+"', '"+message+"' )";
		
		try {
			statement = connection.createStatement();
        	statement.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Request> getRequestInformation(boolean isActive){
		List<Request> activeUsers = new ArrayList<>();
		List<Request> archivedUsers = new ArrayList<>();
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
		String query = "SELECt * FROM userInformation";
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Request request = new Request();
				String status = resultSet.getString("status");
				
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
        		String email = resultSet.getString("email");
        		String message = resultSet.getString("message");
        		String reqStatus = resultSet.getString("status");
        		String time = resultSet.getString("time");
        		
        		request.setId(id);
        		request.setName(name);
        		request.setEmail(email);
        		request.setMessage(message);
        		request.setStatus(reqStatus);
        		request.setTime(time);
        		
        		if(status.equals("active")) {
        			activeUsers.add(request);
        		}
        		else {
        			archivedUsers.add(request);
        		}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(isActive) {
			return activeUsers;
		}
		else {
			return archivedUsers;
		}
	}
	
	public static void changeStatus(String id, String status) {
		Connection connection = null;
		String dataBase = "ContactUs";
		String user = "postgres";
		String passWord = "101010";
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dataBase, user, passWord);
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
		if(status.equals("active")) {
			try {
				String query="UPDATE userInformation SET status='archived' WHERE id = '"+id+"'";
				statement = connection.createStatement();
				statement.executeUpdate(query);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(status.equals("archived")){
			try {
				String query="UPDATE userInformation SET status='active' WHERE id = '"+id+"'";
	  	    	statement = connection.createStatement();
	    	    statement.executeUpdate(query);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	} 
}
