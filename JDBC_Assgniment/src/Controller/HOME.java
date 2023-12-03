package Controller;

import java.util.Scanner;

import dao.*;

public class HOME {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		SaveData sd = new SaveData();
		UpdataDatabyId ud = new UpdataDatabyId();
		DeleteDatabyId dd = new DeleteDatabyId();
		FetchAllData fd = new FetchAllData();
		FetchDataById fi = new FetchDataById();
		VerifyUserByEmailPwd ve = new VerifyUserByEmailPwd();
		while (flag) {
			System.out.println("================HOME PAGE=========================");
			System.out.println("Enter choice");
			System.out.println("1.Insert Data");
			System.out.println("2.Update Data ");
			System.out.println("3.Delete Data");
			System.out.println("4.Fetch ALL Data");
			System.out.println("5.Fetch Data by ID");
			System.out.println("6.Verify email and password");
			System.out.println("7.EXIT");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				sd.save_data();
				break;
			case 2:
				ud.update_data_by_id();
				break;
			case 3:
				dd.delete_data_by_id();
				break;
			case 4:
				fd.fetch_all_data();
				break;
			case 5:
				System.out.println("Enter ID you want to Fetch");
				int id = sc.nextInt();
				fi.fetch_data_by_id(id);
				break;
			case 6:
				System.out.println("Enter email");
				String email = sc.next();
				System.out.println("Enter Password");
				String pwd = sc.next();
				ve.verify_user_by_email(email, pwd);
				break;
			case 7:
				System.out.println("===========THANK YOU=============");
				flag = false;
				break;
			default:
				System.out.println("WRONG CHOICE");
				break;

			}
		
		

		}
		sc.close();

	}
}
