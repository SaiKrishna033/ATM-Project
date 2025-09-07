package com.ATMApplication;

class SavingsAccount extends Account {
	private static final int MIN_BALANCE = 2000;

	public SavingsAccount(int balance) {
		super(balance);
	}

	@Override
	public boolean canWithdraw(int amount) {
		if (balance - amount < MIN_BALANCE) {
			System.out.println("⚠ Withdrawal failed! Minimum balance of ₹" + MIN_BALANCE + " must be maintained.");
			return false;
		}
		return true;
	}

	@Override
	public String getAccountType() {
		return "Savings Account";
	}
}