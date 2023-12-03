package batch_processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class sv {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_jdbc", "root", "root");
			PreparedStatement pst = con
					.prepareStatement("insert into users(name,age,email,password,mobile) values(?,?,?,?,?)");
			while (true) {
				

				System.out.println("Enter Name :");
				String name = sc.next();

				System.out.println("Enter age :");
				int age = sc.nextInt();

				System.out.println("Enter email :");
				String email = sc.next();

				System.out.println("Enter password :");
				String pwd = sc.next();
				System.out.println("Enter Mobile :");
				long mobile = sc.nextLong();
				pst.setString(1, name);
				pst.setInt(2, age);
				pst.setString(3, email);
				pst.setString(4, pwd);
				pst.setLong(5, mobile);
				pst.addBatch();
				System.out.println("Data Inserted");
				System.out.println("Enter 1 to continiue and other number to exit");
				int n = sc.nextInt();
				if (n != 1)
					break;

			}
			int[] batch=pst.executeBatch();
			System.out.println(Arrays.toString(batch));
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
