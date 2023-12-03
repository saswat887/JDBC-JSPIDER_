package jdbc_prepare_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SaveUser1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_jdbc", "root", "root");
			PreparedStatement pst = con.prepareStatement("insert into users(id,name,age,email,password,mobile) values(?,?,?,?,?,?)");
			while (true) {
				System.out.println("Enter id :");
				int id = sc.nextInt();

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
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setInt(3, age);
				pst.setString(4, email);
				pst.setString(5, pwd);
				pst.setLong(6, mobile);
				pst.executeUpdate();
				System.out.println("Data Inserted");
				System.out.println("Do you want to continue press 1 for continue and 2 for exit");
				int exit = sc.nextInt();
				if (exit == 2)
				{
					System.out.println("-----------EXIT---------------");
					break;
				}
				int a=0;
				while (exit != 1 && exit != 2) {
					System.out.println("WRONG CHOICE");
					System.out.println();
					System.out.println("Do you want to continue press 1 for continue and 2 for exit");
					exit = sc.nextInt();
					if (exit == 2)
					{
						a=1;
						System.out.println("-----------EXIT---------------");
						break;
					}
				}
				if(a==1)
					break;
			}

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
