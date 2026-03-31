package ECommerceOrderManagementSystem;

public class WalletPayment implements Payment{
	@Override
	public void pay(double amount)
	throws PaymentFailedException{
		if (amount > 10000) {
			throw new PaymentFailedException("Invalid wallet payment amount");
		}
		System.out.println(" Wallet Payment of "+ amount + " successfull");
	}

}
