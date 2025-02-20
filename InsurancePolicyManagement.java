import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType,
            double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return Objects.equals(policyNumber, that.policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName +
                ", Expiry: " + expiryDate + ", Type: " + coverageType +
                ", Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    // Method to add policy
    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        hashSetPolicies.forEach(System.out::println);
    }

    // Retrieve policies expiring within next 30 days
    public void displayExpiringPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("Policies Expiring Soon:");
        for (InsurancePolicy policy : treeSetPolicies) {
            long daysLeft = ChronoUnit.DAYS.between(today, policy.getExpiryDate());
            if (daysLeft <= 30 && daysLeft >= 0) {
                System.out.println(policy);
            }
        }
    }

    // Retrieve policies by coverage type
    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Identify duplicate policies (policies with the same policy number)
    public void displayDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }
        System.out.println("Duplicate Policies:");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " appears " + entry.getValue() + " times");
            }
        }
    }

    // Performance Comparison
    public void comparePerformance() {
        int testSize = 100000;
        List<InsurancePolicy> testPolicies = new ArrayList<>();

        for (int i = 0; i < testSize; i++) {
            testPolicies.add(new InsurancePolicy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", 500 + i));
        }

        long startTime, endTime;

        // HashSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> testHashSet = new HashSet<>(testPolicies);
        endTime = System.nanoTime();
        System.out.println("HashSet add time: " + (endTime - startTime) + " ns");

        // LinkedHashSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> testLinkedHashSet = new LinkedHashSet<>(testPolicies);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (endTime - startTime) + " ns");

        // TreeSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> testTreeSet = new TreeSet<>(testPolicies);
        endTime = System.nanoTime();
        System.out.println("TreeSet add time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        // Adding sample policies
        system.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 1200.0));
        system.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 800.0));
        system.addPolicy(new InsurancePolicy("P103", "Charlie", LocalDate.now().plusDays(5), "Home", 1500.0));
        system.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 1200.0)); // Duplicate

        // Display all unique policies
        system.displayAllPolicies();

        // Display policies expiring soon
        system.displayExpiringPolicies();

        // Display policies by coverage type
        system.displayPoliciesByCoverage("Auto");

        // Display duplicate policies
        system.displayDuplicatePolicies();

        // Performance comparison
        system.comparePerformance();
    }
}
