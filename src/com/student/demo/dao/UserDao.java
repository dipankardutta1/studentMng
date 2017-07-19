package com.student.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.demo.pojo.User;

public class UserDao {
	
	
	public User getUserByUsernameAndPassword(String username,String password){
		
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_382","root","root");
			
			
			
			
			
			
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			User user = null;
			
			while(resultSet.next()){
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setDob(resultSet.getDate("dob"));
				user.setPhoneNo(resultSet.getString("phone_no"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
			}
			
			return user;
			
		}catch(Exception e){
			return null;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
		
		
		
	}

	public List<User> findAll() {
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_382","root","root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			List<User> userList = new ArrayList<User>();
			
			while(resultSet.next()){
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setDob(resultSet.getDate("dob"));
				user.setPhoneNo(resultSet.getString("phone_no"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				
				userList.add(user);
			}
			
			return userList;
			
		}catch(Exception e){
			return null;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
	}
	
	public void delete(Integer id){

		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_382","root","root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			
			
		}catch(Exception e){
			
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
	}

	public void save(User user) {
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_382","root","root");
			
			String sql = "insert into user(name,phone_no,dob,username,password) values(?,?,?,?,?)";
			
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhoneNo());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.executeUpdate();

			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
		
	}

	public User findById(Integer id) {
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_382","root","root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			User user = null;
			
			
			while(resultSet.next()){
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setDob(resultSet.getDate("dob"));
				user.setPhoneNo(resultSet.getString("phone_no"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				
				
			}
			
			return user;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
		
	}

	public void update(User user) {
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_382","root","root");
			
			String sql = "update user set name = ?,phone_no = ?,dob = ?,username= ? ,password= ? where id = ?";
			
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhoneNo());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setInt(6, user.getId());
			preparedStatement.executeUpdate();

			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
		
	}

}
