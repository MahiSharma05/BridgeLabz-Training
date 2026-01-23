package insurancePolicyManagement;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>(
            Comparator.comparing(Policy::getExpiryDate)
    );

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        hashSet.forEach(System.out::println);
    }

    // Policies expiring within next 30 days
    public void expiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        for (Policy p : hashSet) {
            if (!p.getExpiryDate().isBefore(today)
                    && !p.getExpiryDate().isAfter(next30Days)) {
                System.out.println(p);
            }
        }
    }

    // Policies by coverage type
    public void policiesByCoverage(String coverage) {
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(coverage)) {
                System.out.println(p);
            }
        }
    }

    // Find duplicate policies (based on policy number)
    public void findDuplicates(List<Policy> policies) {
        Set<Integer> seen = new HashSet<>();
        for (Policy p : policies) {
            if (!seen.add(p.getPolicyNumber())) {
                System.out.println("Duplicate Found: " + p);
            }
        }
    }
}

