package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.exceptions.RSAException;

public class Show {
	public void show() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc", "root", "root");
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("Select * from student");
			System.out.println("Rollno\t\tName\t\tMarks");
			while (r.next()) {
				
				System.out.println(r.getInt(1)+"\t\t"+r.getString(2)+"\t\t"+r.getInt(3));
			}
			System.out.println();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
