package batch_processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class sv1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_jdbc", "root", "root");
			Statement stmt=con.createStatement();
			stmt.addBatch("insert into employee(name,age,salary,mobile,email) values('piyushmg',15,2000,'8768','p@gmail.com')");
			stmt.addBatch("update employee set salary=salary+1000 where age>=20");
			stmt.addBatch("update employee set salary=salary+100 where age<=20");
			int[] batch=stmt.executeBatch();
			System.out.println(Arrays.toString(batch));
		}
		catch(Exception e)
		{
			
		}
}
}
