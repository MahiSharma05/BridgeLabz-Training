package InsurancePolicyManagementSystem2;
import java.time.LocalDate;
import java.util.*;

public class PolicyService {

    private Map<Integer, Policy> hashMap = new HashMap<>();
    private Map<Integer, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    // Add policy
    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);

        treeMap
            .computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>())
            .add(policy);
    }

    // Retrieve by policy number
    public Policy getPolicy(int policyNumber) {
        return hashMap.get(policyNumber);
    }

    // Policies expiring in next 30 days
    public void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("\nPolicies expiring within 30 days:");
        for (List<Policy> policies :
                treeMap.subMap(today, true, limit, true).values()) {
            policies.forEach(System.out::println);
        }
    }

    // Policies by policyholder
    public void policiesByHolder(String holder) {
        System.out.println("\nPolicies for " + holder + ":");
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyHolder().equalsIgnoreCase(holder)) {
                System.out.println(policy);
            }
        }
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<Integer, Policy>> iterator =
                hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Policy policy = iterator.next().getValue();
            if (policy.getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(policy.getPolicyNumber());
                treeMap.get(policy.getExpiryDate()).remove(policy);
            }
        }
    }

    // Display all policies
    public void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        hashMap.values().forEach(System.out::println);
    }
}

