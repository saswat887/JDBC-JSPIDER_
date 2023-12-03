package batch_processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.CallableStatement;

public class sv2 {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_jdbc", "root", "root");
		CallableStatement cs= (CallableStatement) con.prepareCall("call selectAll()");
		ResultSet rst=cs.executeQuery();
		while(rst.next())
		{
			System.out.println("id:"+rst.getInt("id"));
			System.out.println("name:"+rst.getString("name"));
			System.out.println("age:"+rst.getInt("age"));
		}
		rst.close();
		cs.close();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
