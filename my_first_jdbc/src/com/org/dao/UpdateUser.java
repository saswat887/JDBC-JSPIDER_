package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateUser 
{
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc", "root", "root");
			Statement s=con.createStatement();
			int r1=s.executeUpdate("insert into employee(id,name,age,salary,mobile,email) values (1,'Saswat',23,20000,'73456','s@gmail')");
			r1=s.executeUpdate("insert into employee(id,name,age,salary,mobile,email) values (2,'Sai',23,20000,'73456','s2@gmail')");
			r1=s.executeUpdate("insert into employee(id,name,age,salary,mobile,email) values (3,'Saswat',23,24000,'73456','s@gmail')");
			r1=s.executeUpdate("insert into employee(id,name,age,salary,mobile,email) values (4,'Piyush',25,20011,'73456','s@gmail')");
			
			System.out.println(r1+" rows inserted");
			
			int r2=s.executeUpdate("delete from employee where name='Saswat'");
			
			System.out.println(r2+" rows deleted");
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}



