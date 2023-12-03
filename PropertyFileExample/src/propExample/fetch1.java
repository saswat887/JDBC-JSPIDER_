package propExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fetch1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_props", "root", "root");
				PreparedStatement pst = con.prepareStatement("select * from student");
					ResultSet rst=pst.executeQuery();)
			{
				while (rst.next()) {
					System.out.println(rst.getInt("id"));
					System.out.println(rst.getString("name"));
					System.out.println(rst.getInt("age"));
					System.out.println(rst.getLong("mobile"));
				}

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
