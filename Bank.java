package com.ATMApplication;

class Bank {
	private User[] users;

	public Bank(User[] users) {
		this.users = users;
	}

	public User getUserById(int userId) {
		for (User user : users) {
			if (user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}
}