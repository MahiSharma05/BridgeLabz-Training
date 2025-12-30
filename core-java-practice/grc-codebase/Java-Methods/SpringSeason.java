// Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 


public class SpringSeason {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please enter month and day as command-line arguments");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (isSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } 
		else {
            System.out.println("Not a Spring Season");
        }
    }
	    
	public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20);
    }
}

