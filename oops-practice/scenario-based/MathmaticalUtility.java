package scenario;

public class MathmaticalUtility {
	
	//Method to calculate factorial
	static int factorial(int n) {
		if(n < 0) {
			return -1;
		}
		int fact = 1;
		for(int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}
	
	// Method to check prime number
	static boolean isPrime(int n) {
		if(n <= 1) {
			return false;
		}
		for(int i = 2; i <= n / 2; i++) {
		    if(n % i == 0) {
			    return false;
		    }
		}
		return true;
	}
	
	//Method to find Greatest Common Divisor
	static int greatestCommonDivisor(int a , int b) {
		if(a < 0) {
			a = -a;
		}
		if(a < 0) {
			a = -a;
		}
		
		while(b !=0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	//Method to find nth Fibonacci number
	static int fibonacci(int n) {
		if(n < 0) {
			return -1;
		}
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		int a = 0 , b =1 , c;
		for(int i = 2; i <=n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String[] args) {
		System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of -3: " + factorial(-3));

        System.out.println("Is 7 Prime? " + isPrime(7));
        System.out.println("Is 1 Prime? " + isPrime(1));

        System.out.println("Greatest common divisor of 24 and 36: " + greatestCommonDivisor(24, 36));
        System.out.println("Greatest common divisor of -8 and 12: " + greatestCommonDivisor(-8, 12));

        System.out.println("Fibonacci of 6: " + fibonacci(6));
        System.out.println("Fibonacci of 0: " + fibonacci(0));
        System.out.println("Fibonacci of -4: " + fibonacci(-4));

	}

}
