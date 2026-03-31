package streamApi;

import java.util.*;
import java.util.stream.*;

class InsuranceClaim {
    private String claimType;
    private double claimAmount;

    public InsuranceClaim(String claimType, double claimAmount) {
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }

    public String getClaimType() {
        return claimType;
    }

    public double getClaimAmount() {
        return claimAmount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("Health", 50000),
            new InsuranceClaim("Vehicle", 20000),
            new InsuranceClaim("Health", 70000),
            new InsuranceClaim("Life", 100000),
            new InsuranceClaim("Vehicle", 30000),
            new InsuranceClaim("Life", 80000)
        );

        // Stream operation
        Map<String, Double> averageClaimByType =
            claims.stream()
                  .collect(
                      Collectors.groupingBy(
                          InsuranceClaim::getClaimType,
                          Collectors.averagingDouble(InsuranceClaim::getClaimAmount)
                      )
                  );

        // Print result
        averageClaimByType.forEach(
            (type, avg) -> System.out.println(type + " → Average Claim: " + avg)
        );
    }
}

