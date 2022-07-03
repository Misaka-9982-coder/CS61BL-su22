/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    private int balance;

    private Account parent;

    /** Initialize an account with the given balance. */
    public Account(int balance) {
        this.balance = balance;
    }

    public Account(int balance, Account parent) {
        this.balance = balance;
        this.parent = parent;
    }

    /** Returns the balance for the current account. */
    public int getBalance() {
        return balance;
    }

    /** Deposits amount into the current account. */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
        // TODO
        if (amount < 0) {
            System.out.println("Cannot withdraw negative amount.");
            return false;
        } else if (amount < balance) {
            balance -= amount;
        } else if (parent != null && balance + parent.balance >= amount) {
            amount -= balance;
            balance = 0;
            parent.balance -= amount;
        } else {
            System.out.println("Insufficient Funds.");
            return false;
        }
        return true;
    }

    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {
        // TODO
        if (other == null) {
            System.out.println("Cannot merge null account.");
        } else {
            balance += other.balance;
            other.balance = 0;
        }
    }
}
