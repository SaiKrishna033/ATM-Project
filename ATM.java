package com.ATMApplication;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class ATM {
	private Bank bank;
	private User activeUser;

	public ATM(Bank bank) {
		this.bank = bank;
	}

	// Check if PIN is 4 digits
	private boolean isValidPin(int pin) {
		return (pin >= 1000 && pin <= 9999);
	}

	// Login
	public boolean authenticateUser(int userId, int pin) {
		User user = bank.getUserById(userId);
		if (user != null && user.getPin() == pin) {
			activeUser = user;
			System.out.println("Welcome " + user.getName() + " (" + user.getAccount().getAccountType() + ")");
			return true;
		}
		System.out.println("⚠ Invalid User ID or PIN!");
		return false;
	}

	// Forgot PIN (OTP based)
	public void forgotPin(int userId, Scanner sc) {
		User user = bank.getUserById(userId);
		if (user != null) {
			Random rand = new Random();
			int otp = 1000 + rand.nextInt(9000);

			System.out.println("Your OTP is: " + otp);
			System.out.print("Enter OTP: ");
			int enteredOtp = sc.nextInt();

			if (enteredOtp == otp) {
				System.out.print("Enter new 4-digit PIN: ");
				int newPin = sc.nextInt();
				System.out.print("Re-enter new PIN: ");
				int rePin = sc.nextInt();

				if (!isValidPin(newPin) || !isValidPin(rePin)) {
					System.out.println("⚠ PIN must be exactly 4 digits!");
				} else if (newPin != rePin) {
					System.out.println("⚠ PINs do not match!");
				} else if (newPin == user.getPin()) {
					System.out.println("⚠ New PIN cannot be same as old PIN!");
				} else {
					user.setPin(newPin);
					System.out.println("PIN reset successful!");
				}
			} else {
				System.out.println("⚠ Incorrect OTP!");
			}
		} else {
			System.out.println("⚠ User not found!");
		}
	}

	// Change PIN (with retry on invalid input)
	public void changePin(Scanner sc) {
		while (true) {
			try {
				System.out.print("Enter old PIN: ");
				int oldPin = sc.nextInt();

				if (oldPin == activeUser.getPin()) {
					System.out.print("Enter new 4-digit PIN: ");
					int newPin = sc.nextInt();
					System.out.print("Re-enter new PIN: ");
					int rePin = sc.nextInt();

					if (!isValidPin(newPin) || !isValidPin(rePin)) {
						System.out.println("⚠ PIN must be exactly 4 digits!");
					} else if (newPin != rePin) {
						System.out.println("⚠ PINs do not match!");
					} else if (newPin == oldPin) {
						System.out.println("⚠ New PIN cannot be same as old PIN!");
					} else {
						activeUser.setPin(newPin);
						System.out.println("PIN changed successfully!");
						return;
					}
				} else {
					System.out.println("⚠ Incorrect old PIN!");
				}
				return;
			} catch (InputMismatchException e) {
				System.out.println("⚠ Invalid input! PIN must be numeric.");
				sc.nextLine(); // clear buffer
			}
		}
	}

	// ATM Menu
	public void showMenu(Scanner sc) {
		int choice = 0;

		while (true) {
			System.out.println("\n===== ATM Menu =====");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Change PIN");
			System.out.println("5. Logout");
			System.out.print("Choose: ");

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("⚠ Invalid input! Please enter numbers only.");
				sc.nextLine();
				continue;
			}

			switch (choice) {
			case 1:
				activeUser.getAccount().checkBalance();
				break;
			case 2:
				while (true) {
					try {
						System.out.print("Enter amount to deposit: ");
						int amount = sc.nextInt();
						activeUser.getAccount().deposit(amount);
						break; // success → exit loop
					} catch (InputMismatchException e) {
						System.out.println("⚠ Invalid input! Please enter numbers only.");
						sc.nextLine();
					}
				}
				break;
			case 3:
				while (true) {
					try {
						System.out.print("Enter amount to withdraw: ");
						int amount = sc.nextInt();
						activeUser.getAccount().withdraw(amount);
						break; // success → exit loop
					} catch (InputMismatchException e) {
						System.out.println("⚠ Invalid input! Please enter numbers only.");
						sc.nextLine();
					}
				}
				break;
			case 4:
				changePin(sc);
				break;
			case 5:
				System.out.println("✅ Logged out successfully!");
				return;
			default:
				System.out.println("⚠ Invalid choice! Please select from above options(1-5).");
			}
		}
	}
}