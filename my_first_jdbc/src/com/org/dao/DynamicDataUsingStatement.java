package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicDataUsingStatement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// load &register
			Class.forName("com.mysql.cj.jdbc.Driver");

			// establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc", "root", "root");

			// create platform
			Statement stmt = con.createStatement();

			System.out.println("Enter id :");
			int id = sc.nextInt();

			System.out.println("Enter Name :");
			String name = sc.next();

			System.out.println("Enter age :");
			int age = sc.nextInt();

			System.out.println("Enter Mobile :");
			String mobile = sc.next();

			// execute query
			String sql = "insert into user(id,name,age,mobile) values(" + id + ",'" + name + "'," + age + ",'" + mobile
					+ "')";
			stmt.execute(sql);

			// close connection
			con.close();
			System.out.println("Registration Successful");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
