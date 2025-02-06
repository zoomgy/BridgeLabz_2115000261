import java.util.ArrayList;

public class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public Account openAccount(Customer customer, double initialBalance) {
        return new Account(customer, this, initialBalance);
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public void viewBalance(Account account) {
        System.out.println("Balance for " + name + ": $" + account.getBalance());
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}

class Account {
    private Customer customer;
    private Bank bank;
    private double balance;

    public Account(Customer customer, Bank bank, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.balance = balance;
        customer.addAccount(this);
    }

    public double getBalance() {
        return balance;
    }
}

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank");
        Customer alice = new Customer("Alice");

        Account account = bank.openAccount(alice, 1000);
        alice.viewBalance(account);
    }
}