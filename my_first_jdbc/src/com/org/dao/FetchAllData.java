package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchAllData 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc","root","root");
			Statement stmt=con.createStatement();
			String sql="select * from user";
			ResultSet rst=stmt.executeQuery(sql);
			
			while(rst.next())
			{
				/*
				System.out.println(rst.getInt(1));
				System.out.println(rst.getString(2));
				System.out.println(rst.getInt(3));
				System.out.println(rst.getString(4));
				*/
				System.out.println(rst.getInt("id"));
				System.out.println(rst.getString("name"));
				System.out.println(rst.getInt("age"));
				System.out.println(rst.getString("mobile"));
				System.out.println("-------------------------");
			}
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
