package ECommerceOrderManagementSystem;

public class UPIPayment implements Payment{
	@Override
	public void pay(double amount)
	throws PaymentFailedException{
		if (amount > 50000) {
			throw new PaymentFailedException("UPI payment limit exceeded");
		}
		System.out.println(" UPI Payment of "+ amount + " successfull");
	}

}