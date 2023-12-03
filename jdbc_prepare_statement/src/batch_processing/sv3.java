package batch_processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class sv3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_jdbc", "root", "root");
			CallableStatement cs= (CallableStatement) con.prepareCall("call insertdatan(1000,'sachin',50)");
			int n=cs.executeUpdate();
			System.out.println(n+" no of rows affected");
			cs.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
