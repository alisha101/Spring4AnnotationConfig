package com.result;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbconnection.DBConnection;

public class DALResult {
	
	public ArrayList<Result> getAllResult() throws SQLException {
		
		String query="select * from user_result";
		DBConnection db = new DBConnection();
		Statement s = db.connection().createStatement();
		ResultSet rs=s.executeQuery(query);

		ArrayList<Result> al = new ArrayList<>();
	
		while(rs.next()) {
			int id = rs.getInt("id");
			String userid = rs.getString("userid");
			String score = rs.getString("score");
		
			Result u = new Result(id,userid,score);
			al.add(u);
		}
		System.out.println(al);
		db.close();
		return al;
	}
	
}
