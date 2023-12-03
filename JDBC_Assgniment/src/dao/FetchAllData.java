package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class FetchAllData {
	public void fetch_all_data()
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
					ResultSet rst=stmt.executeQuery("select id,name,mobile,email from user");
					){
				
					while(rst.next())
					{
						System.out.println("ID:-"+rst.getInt("id"));
						System.out.println("NAME:-"+rst.getString("name"));
						System.out.println("MOBILE:-"+rst.getString("mobile"));
						System.out.println("EMAIL:-"+rst.getString("email"));
						System.out.println("***************************************");
					}
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
