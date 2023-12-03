package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Enter {
	public void enter() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc", "root", "root");
			Statement s = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter roll no");
			int r = sc.nextInt();
			System.out.println("Enter Name");
			String n = sc.next();
			System.out.println("Enter mark");
			int m = sc.nextInt();
			String sql = "insert into student(rollno,name,marks) values(" + r + ",'" + n + "'," + m + ")";
			System.out.println("DATA INSERTED");
			s.execute(sql);
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
