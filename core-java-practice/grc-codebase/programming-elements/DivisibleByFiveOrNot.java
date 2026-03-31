//Write a program to check if a number is divisible by 5


public class DivisibleByFiveOrNot{
    public static void main(String [] args){
	    Scanner input = new Scanner(System.in);
		  int number = input.nextInt();
		if(number % 5 == 0){
		    System.out.println("the number " + number + "is divisible by 5");
		}
		else{
		    System.out.println("the number " + number + "is not divisible by 5.");
		}
	}
}
	