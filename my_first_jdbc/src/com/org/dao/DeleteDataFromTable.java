package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDataFromTable {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc", "root", "root");
			Statement stmt = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id :");
			int id = sc.nextInt();
			stmt.execute("delete from user where id=" + id);
			con.close();
			System.out.println("Data Deleted");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
