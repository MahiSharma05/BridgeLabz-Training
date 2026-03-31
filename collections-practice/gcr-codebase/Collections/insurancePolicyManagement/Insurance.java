package insurancePolicyManagement;

import java.time.LocalDate;
import java.util.List;

public class Insurance {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy(101, "Amit", LocalDate.now().plusDays(20), "Health", 5000);
        Policy p2 = new Policy(102, "Neha", LocalDate.now().plusDays(60), "Auto", 7000);
        Policy p3 = new Policy(103, "Rahul", LocalDate.now().plusDays(10), "Home", 6000);
        Policy p4 = new Policy(101, "Amit", LocalDate.now().plusDays(20), "Health", 5000); // duplicate

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        System.out.println("All Unique Policies:");
        manager.displayAllPolicies();

        System.out.println("\n Expiring Soon:");
        manager.expiringSoon();

        System.out.println("\n Health Policies:");
        manager.policiesByCoverage("Health");

        System.out.println("\n Duplicate Check:");
        manager.findDuplicates(List.of(p1, p2, p3, p4));
    }
}

