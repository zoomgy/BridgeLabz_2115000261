abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public abstract double calculateInterest();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04;
    }
}

// Main Class to Test
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc = new SavingsAccount("123456", "John Doe", 50000);
        System.out.println("Interest Earned: " + acc.calculateInterest());
    }
}
