import java.util.*;
import java.time.*;

// Insurance Policy Management System
class InsurancePolicy {
    String policyNumber, policyholderName;
    LocalDate expiryDate;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName + " (Expires: " + expiryDate + ")";
    }
}

class InsuranceSystem {
    HashMap<String, InsurancePolicy> policies = new HashMap<>();
    LinkedHashMap<String, InsurancePolicy> orderedPolicies = new LinkedHashMap<>();
    TreeMap<LocalDate, List<InsurancePolicy>> sortedByExpiry = new TreeMap<>();

    void addPolicy(InsurancePolicy policy) {
        policies.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        sortedByExpiry.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    InsurancePolicy getPolicy(String policyNumber) {
        return policies.get(policyNumber);
    }

    List<InsurancePolicy> getExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        return sortedByExpiry.subMap(today, next30Days).values().stream().flatMap(List::stream).toList();
    }

    List<InsurancePolicy> getPoliciesByHolder(String name) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : policies.values()) {
            if (policy.policyholderName.equals(name)) {
                result.add(policy);
            }
        }
        return result;
    }
}

// Voting System
class VotingSystem {
    HashMap<String, Integer> votes = new HashMap<>();
    TreeMap<String, Integer> sortedVotes;
    LinkedHashMap<String, Integer> orderedVotes = new LinkedHashMap<>();

    void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, votes.get(candidate));
        sortedVotes = new TreeMap<>(votes);
    }

    void displayResults() {
        System.out.println("Sorted Results: " + sortedVotes);
        System.out.println("Vote Order: " + orderedVotes);
    }
}

// Shopping Cart
class ShoppingCart {
    HashMap<String, Double> productPrices = new HashMap<>();
    LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    TreeMap<Double, String> sortedByPrice = new TreeMap<>();

    void addProduct(String product, double price) {
        productPrices.put(product, price);
        sortedByPrice.put(price, product);
    }

    void addToCart(String product) {
        cart.put(product, cart.getOrDefault(product, 0) + 1);
    }

    void displayCart() {
        System.out.println("Cart: " + cart);
        System.out.println("Products Sorted by Price: " + sortedByPrice);
    }
}

// Banking System
class BankingSystem {
    HashMap<String, Double> accounts = new HashMap<>();
    TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    Queue<String> withdrawalQueue = new LinkedList<>();

    void createAccount(String accNum, double balance) {
        accounts.put(accNum, balance);
        sortedAccounts.put(balance, accNum);
    }

    void requestWithdrawal(String accNum) {
        withdrawalQueue.add(accNum);
    }

    void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accNum = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for: " + accNum);
        }
    }
}

public class FinalAnswers {
    public static void main(String[] args) {
        // Insurance System
        InsuranceSystem insuranceSystem = new InsuranceSystem();
        insuranceSystem.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(10)));
        insuranceSystem.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(40)));
        System.out.println("Expiring Policies: " + insuranceSystem.getExpiringPolicies());

        // Voting System
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.vote("Alice");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");
        votingSystem.displayResults();

        // Shopping Cart
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1500);
        cart.addProduct("Phone", 800);
        cart.addToCart("Laptop");
        cart.addToCart("Phone");
        cart.displayCart();

        // Banking System
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.createAccount("ACC123", 5000);
        bankingSystem.createAccount("ACC124", 3000);
        bankingSystem.requestWithdrawal("ACC123");
        bankingSystem.processWithdrawals();
    }
}
