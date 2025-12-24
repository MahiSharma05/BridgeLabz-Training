//Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights

import java.util.Scanner;

public class FriendsAgeHeightComparison{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        //input for Amar
        System.out.print("Enter Amar's age:");
        int amarAge = input.nextInt();
        System.out.print("Enter Amar's height:");
        int amarHeight = input.nextInt();

        //input for Akbar
        System.out.print("Enter Akbar's age:");
        int akbarAge = input.nextInt();
        System.out.print("Enter Akbar's height:");
        int akbarHeight = input.nextInt();

        //input for Anthony
        System.out.print("Enter Anthony's age:");
        int anthonyAge = input.nextInt();
        System.out.print("Enter Anthony's height:");
        int anthonyHeight = input.nextInt();

        // Finding youngest friend
        if(amarAge <= akbarAge && amarAge <= anthonyAge){
            System.out.println("Youngest friend is Amar");
        }
		else if(akbarAge <= amarAge && akbarAge <= anthonyAge){
            System.out.println("Youngest friend is Akbar");
        } 
		else{
            System.out.println("Youngest friend is Anthony");
        }

        // Finding tallest friend
        if(amarHeight >= akbarHeight && amarHeight >= anthonyHeight){
            System.out.println("Tallest friend is Amar");
        } 
		else if(akbarHeight >= amarHeight && akbarHeight >= anthonyHeight){
            System.out.println("Tallest friend is Akbar");
        } 
		else{
            System.out.println("Tallest friend is Anthony");
        }
        input.close();
    }
}
