package FunctionalInterfaces;

interface Payment{
	public void pay();
}

// UPI class
class UPI implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through UPI");	
	}	
}

// Credit Card class
class CreditCard implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through CreditCard");
		
	}
}

// Wallet class
class Wallet implements Payment{
	@Override
	public void pay() {
		System.out.println("Paying through Wallet");
		
	}
}

public class DigitalPayment {

	public static void main(String[] args) {
		UPI upi = new UPI();
		CreditCard creditCard = new CreditCard();
		Wallet wallet = new Wallet();
		upi.pay();
		creditCard.pay();
		wallet.pay();
		
		
		

	}

}
