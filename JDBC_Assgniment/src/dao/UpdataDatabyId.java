package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class UpdataDatabyId {
	public void update_data_by_id()
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
					PreparedStatement pst=con.prepareStatement("update user set name=?,mobile=?,email=?,password=? where id=? ");
					){
					System.out.println("Enter id you want to update");
					int id=sc.nextInt();
					System.out.println("Enter name");
					String name=sc.next();
					System.out.println("Enter mobile");
					String mobile=sc.next();
					System.out.println("Enter email");
					String email=sc.next();
					System.out.println("Enter password");
					String pwd=sc.next();
					pst.setString(1, name);
					pst.setString(2, mobile);
					pst.setString(3, email);
					pst.setString(4, pwd);
					pst.setInt(5, id);
					pst.execute();
		
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
