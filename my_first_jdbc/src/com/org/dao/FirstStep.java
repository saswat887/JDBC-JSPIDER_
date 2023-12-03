package com.org.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class FirstStep {
	public static void main(String[] args) {
		try 
		{
			java.sql.Driver d=new Driver();//Loading
			DriverManager.registerDriver(d);//Registering
			System.out.println("Loading and Registering is complete");	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
