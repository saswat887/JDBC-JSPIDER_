package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	public void delete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_jdbc", "root", "root");
			Statement s = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the rollno you want to detete");
			int id = sc.nextInt();
			ResultSet r = s.executeQuery("Select name from student where rollno="+id);
			while(r.next())
			{
				System.out.println(r.getString(1)+" data deleted");
			}
			s.execute("delete from student where rollno=" + id);
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
