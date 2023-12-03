package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class DeleteDatabyId {
	public void delete_data_by_id()
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
					PreparedStatement pst=con.prepareStatement("delete from user where id=?");
					){
				System.out.println("Enter the id you want to delete");
				int id=sc.nextInt();
				pst.setInt(1, id);
				int a=pst.executeUpdate();
				if(a==0)
					System.out.println("Invalid Id");
				else
					System.out.println("Data Deleted");
				
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
