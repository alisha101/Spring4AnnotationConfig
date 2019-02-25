package com.user;

import com.dbconnection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DALUser {
    
   public ArrayList<User> getAllUsers() throws SQLException {
       ArrayList<User> al = new ArrayList<>();
       
       String query = "select * from user";
       DBConnection db = new DBConnection();
       Statement s = db.connection().createStatement();
       ResultSet rs = s.executeQuery(query);
       while(rs.next()) {
           int id = rs.getInt("id");
           String name = rs.getString("name");
           String username = rs.getString("username");
           String pwd = rs.getString("password");
           String role  = rs.getString("role");
           
           User u = new User(id,name,username,pwd,role);
           al.add(u);
       }
       System.out.println(al);
       db.close();
       return al;
   }
    
	public void registerUsers() throws SQLException {
	
		User user = new User();
	
		int id = user.getId();
		String name = user.getName();
		String username = user.getUsername();
		String password = user.getPassword();
		String role = user.getRole();	
		
		String query="insert into user (id,name,username,password,role)" + "values(?,?,?,?,?)" ;

		DBConnection db = new DBConnection();
		PreparedStatement s = db.connection().prepareStatement(query);
		s.setInt (1, id);
		s.setString (2, name);
		s.setString (3, username);
		s.setString (4, password);
		s.setString (5, role);

		s.execute();

//		String query="insert into user values (id,name,username,pwd,role)";
//		DBConnection db = new DBConnection();
//		Statement s = db.connection().createStatement();
//		s.executeQuery(query);
	
		db.close();
	}
}