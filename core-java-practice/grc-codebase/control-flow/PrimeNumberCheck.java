//Write a Program to check if the given number is a prime number or not

import java.util.Scanner;

public class PrimeNumberCheck{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number:");
        int number = input.nextInt();

        // Prime check applies only for numbers > 1
        if(number <= 1){
            System.out.println(number +" is NOT a Prime Number");
        }
		else{
            boolean isPrime = true;
            for (int i = 2; i < number; i++) {

                // Check divisibility
                if (number % i == 0) {
                    isPrime = false;
					// number is divisible by some other number
                    break; 
                }
            }
            if(isPrime){
                System.out.println(number +" is a Prime Number");
            }
			else{
                System.out.println(number +" is NOT a Prime Number");
            }
        }
        input.close();
    }
}
