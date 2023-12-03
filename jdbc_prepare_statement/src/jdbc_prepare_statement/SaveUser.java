package jdbc_prepare_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveUser {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_jdbc","root","root");
			PreparedStatement pst=con.prepareStatement("insert into users(id,name,age,email,password,mobile) values(?,?,?,?,?,?)");
			pst.setInt(1, 110);
			pst.setString(2, "Saswat");
			pst.setInt(3, 23);
			pst.setString(4, "scasw3at887@gmail.com");
			pst.setString(5,"12345" );
			pst.setLong(6, 732785893);
			pst.executeUpdate();
			
			/*pst.setInt(1, 102);
			pst.setString(2, "Saswat");
			pst.setInt(3, 23);
			pst.setString(4, "sbaswat887@gmail.com");
			pst.setString(5,"12345" );
			pst.setLong(6, 732785893);
			pst.executeUpdate();
			
			
			pst.setInt(1, 1033);
			pst.setString(2, "Saswat");
			pst.setInt(3, 23);
			pst.setString(4, "sda3swat887@gmail.com");
			pst.setString(5,"12345" );
			pst.setLong(6, 732785893);
			pst.executeUpdate();
			con.close();
			System.out.println("Data Inserted");*/
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
