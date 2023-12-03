package com.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Enter e = new Enter();
		Delete d = new Delete();
		Show s = new Show();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter choice");
			System.out.println("1.Enter");
			System.out.println("2.Delete");
			System.out.println("3.Show");
			System.out.println("4.Exit");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				
				e.enter();
				break;
			case 2:
				
				d.delete();
				break;
			case 3:
				
				s.show();
				break;
			case 4:
				System.out.println("AGAIN RUN THE PROGRAM");
				flag = false;
				break;
			default:
				System.out.println("Wrong choice");

			}
		}
	}

}
