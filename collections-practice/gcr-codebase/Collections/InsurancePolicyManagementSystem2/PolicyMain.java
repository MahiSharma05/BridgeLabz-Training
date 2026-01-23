package InsurancePolicyManagementSystem2;
import java.time.LocalDate;

public class PolicyMain {

    public static void main(String[] args) {

        PolicyService service = new PolicyService();

        service.addPolicy(new Policy(101, "Alice", LocalDate.now().plusDays(10), "Health", 5000));

        service.addPolicy(new Policy(102, "Bob", LocalDate.now().plusDays(40), "Auto", 7000));

        service.addPolicy(new Policy(103, "Alice", LocalDate.now().minusDays(5), "Home", 6000));

        // Retrieve policy
        System.out.println("Retrieve Policy 101:");
        System.out.println(service.getPolicy(101));

        // Expiring soon
        service.policiesExpiringSoon();

        // Policies by holder
        service.policiesByHolder("Alice");

        // Remove expired
        service.removeExpiredPolicies();

        // Display remaining
        service.displayAllPolicies();
    }
}

