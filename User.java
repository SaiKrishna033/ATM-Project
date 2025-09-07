package com.ATMApplication;

class User {
	private int userId;
	private String name;
	private int pin;
	private Account account;

	public User(int userId, String name, int pin, Account account) {
		this.userId = userId;
		this.name = name;
		this.pin = pin;
		this.account = account;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Account getAccount() {
		return account;
	}
}