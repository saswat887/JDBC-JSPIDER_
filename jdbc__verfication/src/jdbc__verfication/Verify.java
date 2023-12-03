package jdbc__verfication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Verify {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_jdbc","root","root");
			Statement stmt=con.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your Email id");
			String email=sc.next();
			System.out.println("Enter your password");
			String pwd=sc.next();
			String sql="select * from emp where email='"+email+"' and pasword='"+pwd+"'";
			ResultSet r=stmt.executeQuery(sql);
			if(r.next())
			{
				System.out.println("WELCOME TO HOME PAGE");
			}
			else
			{
				System.out.println("WRONG EMAIL OR PASSWORD");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
