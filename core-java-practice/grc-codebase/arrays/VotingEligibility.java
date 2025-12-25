//Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.

import java.util.Scanner;

public class VotingEligibility{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // array to store ages of 10 students
        int[] ages = new int[10];

        // Take input for ages
        for(int i = 0; i < ages.length; i++){
            System.out.println("Enter age of student "+(i + 1) + ": ");
            ages[i] = input.nextInt();
        }

        System.out.println("\nVoting Eligibility Results:");

        // check voting eligibility
        for(int i = 0; i < ages.length; i++){
            if(ages[i] < 0){
                System.out.println("Invalid age entered: "+ ages[i]);
            } 
            else if(ages[i] >= 18){
                System.out.println("The student with the age " + ages[i]+ " can vote.");
            } 
            else{
                System.out.println("The student with the age "+ ages[i]+ " cannot vote.");
            }
        }
        input.close();
    }
}
