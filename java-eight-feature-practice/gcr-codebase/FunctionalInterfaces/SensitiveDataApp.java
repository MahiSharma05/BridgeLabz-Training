package FunctionalInterfaces;

// Custom marker interface (no methods)
interface SensitiveData {
    // Marker only
}

// Class containing sensitive information
class CustomerAccount implements SensitiveData {

    private String accountNumber;
    private String customerName;

    public CustomerAccount(String accountNumber, String customerName) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Class with non-sensitive data
class PublicProductInfo {
    private String productName;

    public PublicProductInfo(String productName) {
        this.productName = productName;
    }
}

// Encryption processor
class EncryptionService {

    static void process(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println("🔐 Encrypting sensitive data: "
                    + obj.getClass().getSimpleName());
            // encryption logic here
        } else {
            System.out.println("No encryption required for: "
                    + obj.getClass().getSimpleName());
        }
    }
}

public class SensitiveDataApp {

    public static void main(String[] args) {

        CustomerAccount account =
                new CustomerAccount("ACC12345", "Mahi");

        PublicProductInfo product =
                new PublicProductInfo("Laptop");

        EncryptionService.process(account);
        EncryptionService.process(product);
    }
}
