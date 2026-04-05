package practice2;
import java.util.*;
class Transaction{
	String type;
	int amount;
	int remainingLimit;
public Transaction(String type , int amount , int remainingLimit){
	this.type = type;
    this.amount = amount;
    this.remainingLimit = remainingLimit;
}
	
}
class CreditCard{
	String cardNumber;
	String holderName;
	int creditLimit;
	int availableLimit;
	List<Transaction> transactions;
public CreditCard(String cardNumber , String holderName , int creditLimit) {
	this.cardNumber = cardNumber;
	this.holderName = holderName;
	this.creditLimit = creditLimit;
	this.availableLimit = creditLimit;
	this.transactions = new ArrayList<>();
}
}

public class CreditAccountManagement {
	static Map<String,CreditCard> cardMap = new HashMap<>();
	
	public static void issueCard(String cardNumber , String holderName , int creditLimit) {
		if(!cardMap.containsKey(cardNumber)) {
			CreditCard card = new CreditCard(cardNumber ,holderName , creditLimit);
			cardMap.put(cardNumber, card);
		}
	}

	public static void spendAmount(String cardNumber , int amount) {
		if(!cardMap.containsKey(cardNumber)) {
			System.out.println("Transaction declined");
			return;
		}
		CreditCard card = cardMap.get(cardNumber);
		if(amount <= card.availableLimit) {
			card.availableLimit -= amount;
			card.transactions.add(new Transaction("SPEND", amount, card.availableLimit));
			System.out.println("SPENT " + cardNumber +" "+ card.availableLimit);
		}
		else {
			System.out.println("Transaction declined");
		}
	}

	public static void makePayment(String cardNumber , int amount) {
		if(!cardMap.containsKey(cardNumber)) {
			System.out.println("card not found");
			return;
		}
		CreditCard card = cardMap.get(cardNumber);
		card.availableLimit += amount;
		if(card.availableLimit > card.creditLimit) {
			card.availableLimit = card.creditLimit;
		}
		card.transactions.add(new Transaction("PAYMENT" ,  amount , card.availableLimit));
		System.out.println("PAYMENT DONE" + cardNumber + " "+ card.availableLimit);
	}

	public static void cardsByHolder(String holderName) {
		List<CreditCard> holderNames = new ArrayList<>();
		for(CreditCard card : cardMap.values()) {
			if(card.holderName.equals(holderName)) {
				holderNames.add(card);
			}
			
		}
		if(holderNames.isEmpty()) {
			System.out.println("No card Found");
			return;
		}
		Collections.sort(holderNames,(a,b) -> a.cardNumber.compareTo(b.cardNumber));
		for(CreditCard card : holderNames) {
			System.out.println(card.cardNumber+" " + card.availableLimit);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("input");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String[] part = input.split(" ");
			String command = part[0];
			switch(command){
			case "ISSUE":
				issueCard(part[1] , part[2] , Integer.parseInt(part[3]));
				break;
			case "SPEND":
				spendAmount(part[1] , Integer.parseInt(part[2]));
				break;
			case "PAYMENT":
				makePayment(part[1] , Integer.parseInt(part[2]));
				break;
			case "HOLDER":
				cardsByHolder(part[1]);
				break;
			}
		}

	}

}
