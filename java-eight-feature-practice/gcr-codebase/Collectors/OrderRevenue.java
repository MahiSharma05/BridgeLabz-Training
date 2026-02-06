package Collectors;
import java.util.*;
import java.util.stream.*;
class Orders{
	String name;
	double amount;
Orders(String name, double amount){
	this.name = name;
	this.amount = amount;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

}

public class OrderRevenue {

	public static void main(String[] args) {
		List<Orders> orderList = Arrays.asList(new Orders("Mahi", 2000.12),
				new Orders("Deepa", 3000.0),
				new Orders("Rahul" , 1000.21),
				new Orders("Mansi", 4000.0));
		
		// Sum order totals per customer
        Map<String, Double> revenueByCustomer =
        		orderList.stream()
                      .collect(Collectors.groupingBy(
                    		  Orders::getName,
                              Collectors.summingDouble(Orders::getAmount)
                      ));

        // Print result
        revenueByCustomer.forEach((customer, total) ->
                System.out.println(customer + " -> " + total)
        ); 
		

	}

}
