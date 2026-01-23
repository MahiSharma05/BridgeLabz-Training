package InsurancePolicyManagementSystem2;

import java.time.LocalDate;

public class Policy {

    private int policyNumber;
    private String policyHolder;
    private LocalDate expiryDate;
    private String coverageType;
    private double premium;

    public Policy(int policyNumber, String policyHolder,
                  LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyHolder + " | "
                + expiryDate + " | " + coverageType + " | ₹" + premium;
    }
}

