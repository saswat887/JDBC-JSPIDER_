package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstStepForNameWay 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//1st step load & register
		//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");//2nd step establishing connection 1st way
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc", "root", "root");//2nd step establishing connection 2nd way
			Statement stmt=con.createStatement();//3rd Step :-Create Platform
			//stmt.execute("insert into user(id,name,age,mobile) values(1,'SASWAT',23,'7327858936')");//4th Step:-Executing the query
			String sql="insert into user(id,name,age,mobile) values(2,'PIYUSH',23,'12345')";
			stmt.execute(sql);
			con.close();//5th step:-Close the connection
			System.out.println("Load & Register complete");
			System.out.println("Connection Estabished");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
