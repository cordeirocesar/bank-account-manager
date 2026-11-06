package com.bank;

public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;


    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient account balance.");
        }

        this.balance -= amount;

    }
}


