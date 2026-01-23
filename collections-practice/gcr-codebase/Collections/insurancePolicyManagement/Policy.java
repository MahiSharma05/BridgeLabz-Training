package insurancePolicyManagement;
import java.time.LocalDate;
import java.util.Objects;

public class Policy {
	private int policyNumber;
	private String policyHolderName;
	private LocalDate expiryDate;
	private String coverageType;
	private double premiumAmount;
public Policy(int policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
	this.policyNumber = policyNumber;
	this.policyHolderName = policyHolderName;
	this.expiryDate = expiryDate;
	this.coverageType = coverageType;
	this.premiumAmount = premiumAmount;
}
public int getPolicyNumber() {
	return policyNumber;
}
public void setPolicyNumber(int policyNumber) {
	this.policyNumber = policyNumber;
}
public LocalDate getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(LocalDate expiryDate) {
	this.expiryDate = expiryDate;
}
public String getCoverageType() {
	return coverageType;
}
public void setCoverageType(String coverageType) {
	this.coverageType = coverageType;
}

@Override
public boolean equals(Object o) {
	if (this == o) return true;
    if (!(o instanceof Policy)) return false;
    Policy policy = (Policy) o;
    return policyNumber == policy.policyNumber;
}
@Override
public int hashCode() {
    return Objects.hash(policyNumber);
}

@Override
public String toString() {
    return "Policy{" +
            "policyNumber=" + policyNumber +
            ", name='" + policyHolderName + '\'' +
            ", expiryDate=" + expiryDate +
            ", coverageType='" + coverageType + '\'' +
            ", premium=" + premiumAmount +
            '}';
} 

}
