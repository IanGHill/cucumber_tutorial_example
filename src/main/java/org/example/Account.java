package org.example;

public class Account {
    private int balance;

    public void deposit(int amount){
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
