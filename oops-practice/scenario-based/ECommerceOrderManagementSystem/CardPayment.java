package ECommerceOrderManagementSystem;

public class CardPayment implements Payment{
	@Override
	public void pay(double amount)
	throws PaymentFailedException{
		if (amount <= 0) {
			throw new PaymentFailedException("Invalid card payment amount");
		}
		System.out.println(" Card Payment of "+ amount + " successfull");
	}

}
