package jdbc__verfication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VerifyE {
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
			String sql="select * from emp where email='"+email+"'";
			ResultSet rst=stmt.executeQuery(sql);
			if(rst.next())
			{
				String dbPwd=rst.getString("pasword");
				if(pwd.equals(dbPwd))
					System.out.println("Welcome to the Home PAGE");
				else
					System.out.println("INVALID Password");
			}
			else
			{
				System.out.println("Invalid Email");
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
