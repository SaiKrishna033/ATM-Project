package com.ATMApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mainChoice = 0;

		 User[] users = new User[] {
		            new User(101, "Alice", 1234, new SavingsAccount(8000)),
		            new User(102, "Bob", 4321, new CurrentAccount(15000)),
		            new User(103, "Charlie", 2222, new SavingsAccount(12000)),
		            new User(104, "David", 9999, new CurrentAccount(20000)),
		            new User(105, "Eve", 5555, new SavingsAccount(5000)),
		            new User(106, "Frank", 6666, new CurrentAccount(25000)),
		            new User(107, "Grace", 7777, new SavingsAccount(7000)),
		            new User(108, "Hank", 8888, new CurrentAccount(30000)),
		            new User(109, "Ivy", 1111, new SavingsAccount(9500)),
		            new User(110, "Jack", 2223, new CurrentAccount(12000)),
		            new User(111, "Kim", 3333, new SavingsAccount(4000)),
		            new User(112, "Leo", 4444, new CurrentAccount(18000))
		        };

		Bank bank = new Bank(users);
		ATM atm = new ATM(bank);

		while (true) {
			System.out.println("\n===== Welcome to ATM =====");
			System.out.println("1. Login");
			System.out.println("2. Forgot PIN");
			System.out.println("3. Exit");
			System.out.print("Choose: ");

			try {
				mainChoice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("⚠ Invalid input! Please select from above options.");
				sc.nextLine();
				continue;
			}
			if (mainChoice == 1) {
				try {
					System.out.print("Enter User ID: ");
					int uid = sc.nextInt();
					System.out.print("Enter 4-digit PIN: ");
					int pin = sc.nextInt();

					if (atm.authenticateUser(uid, pin)) {
						atm.showMenu(sc);
					}
				} catch (InputMismatchException IE) {
					System.out.println("⚠ Invalid input! Please enter numbers only.");
					sc.nextLine();
					continue;
				} catch (Exception e) {
					System.out.println("⚠ Invalid input! User ID and PIN must be numbers.");
					sc.nextLine();
				}
			} else if (mainChoice == 2) {
				try {
					System.out.print("Enter User ID: ");
					int id = sc.nextInt();
					atm.forgotPin(id, sc);
				} catch (Exception e) {
					System.out.println("⚠ Invalid input! User ID must be numbers.");
					sc.nextLine();
				}
			} else if (mainChoice == 3) {
				System.out.println("Thank you for using ATM!");
				break;
			} else {
				System.out.println("⚠ Invalid choice! Please select from above options.");
			}
		}
	}
}
