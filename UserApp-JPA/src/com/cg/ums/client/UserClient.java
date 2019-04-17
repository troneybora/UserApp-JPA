package com.cg.ums.client;

import java.util.Scanner;

import com.cg.ums.entities.User;
import com.cg.ums.service.UserService;
import com.cg.ums.service.UserServiceImpl;

public class UserClient {

	public static void main(String[] args) {
		UserService service = new UserServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("**************User Management System**************");
			System.out.println("Enter your choice:- ");
			System.out.println("1. Fetch Names ending with user input");
			System.out.println("2. User Count");
			System.out.println("3. Email in ascending order");
			System.out.println("4. Exit");
			System.out.print("Answer:- ");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:

				int flag = 1;
				System.out.println("Enter the last character:- ");
				System.out.print("Answer:- ");
				char lastCharac = sc.next().charAt(0);
				for (User user : service.findByName(lastCharac)) {
					System.out.println(user);
					flag++;
				}
				if (flag == 1) {
					System.out.println("Ending with " + lastCharac + " not available");
				}
				System.out.println("**************************************************");
				
				break;

			case 2:

				System.out.println("Total Users:" + service.findCount());
				System.out.println("**************************************************");
				
				break;

			case 3:

				for (User user : service.findAllByEmailAsc()) {
					System.out.println(user);
				}
				System.out.println("**************************************************");
				
				break;

			case 4:
				System.out.println("Done Exiting!!!!");
				System.exit(0);

			default:

				System.out.println("Invalid Choice");

			}

		}

	}

}
