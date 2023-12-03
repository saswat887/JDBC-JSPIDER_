package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateAgeById {
	public static void main(String[] args) {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc", "root", "root");
			Statement stmt=con.createStatement();
			stmt.execute("update user set age=100 where id=1");
			con.close();
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
