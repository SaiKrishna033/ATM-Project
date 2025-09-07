package com.ATMApplication;

class CurrentAccount extends Account {
	private static final int MIN_BALANCE = 5000;

	public CurrentAccount(int balance) {
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
		return "Current Account";
	}
}
