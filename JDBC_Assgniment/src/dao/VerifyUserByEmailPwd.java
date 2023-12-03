package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class VerifyUserByEmailPwd {
	public void verify_user_by_email(String email,String pwd)
	{
		Properties p=new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\saswa\\Desktop\\OOPS\\JDBC_Assgniment\\lib\\jdbc.properties");
			p.load(fis);
			Class.forName(p.getProperty("driver"));
			Scanner sc=new Scanner(System.in);
			try (
					
					Connection con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
					Statement stmt=con.createStatement();
					ResultSet rst=stmt.executeQuery("select * from user where password='"+pwd+"'and email='"+email+"'");
					){
				int c=0;
				while(rst.next())
				{
					c++;
				}
				if(c==1)
					System.out.println("Username password correct");
				else 
					System.out.println("Username or password wrong");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();
		
	}

}
