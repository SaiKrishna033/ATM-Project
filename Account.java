package com.ATMApplication;
abstract class Account implements ATMOperations {
    protected int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void checkBalance() {
        System.out.println("Balance: ₹" + balance);
    }

    @Override
    public void deposit(int amount) {
        boolean valid = true;

        if (amount >= 50000) {
            System.out.print("⚠ Deposit failed! Amount must be less than ₹50,000");
            valid = false;
        }

        if (amount % 100 != 0) {
            if (!valid) {
                System.out.print(" and in multiples of 100");
            } else {
                System.out.print("⚠ Deposit failed! Amount must be in multiples of 100");
                valid = false;
            }
        }

        if (!valid) {
            System.out.println(".");
            return;
        }

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " successfully.");
        } else {
            System.out.println("⚠ Deposit failed! Amount must be greater than 0.");
        }
    }

    public abstract String getAccountType();
    public abstract boolean canWithdraw(int amount);
    
    @Override
    public void withdraw(int amount) {
        if (amount > 25000 || amount <= 0 || amount % 100 != 0) {
            System.out.println("⚠ Withdrawal failed! Amount must be >0, ≤25000, and in multiples of 100.");
            return;
        }
        if (!canWithdraw(amount)) {
            return; // child class will print min balance error
        }
        balance -= amount;
        System.out.println("Withdrawn ₹" + amount + " successfully.");
    }
}