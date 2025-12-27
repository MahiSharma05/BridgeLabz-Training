//Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.

import java.util.Scanner;
import java.util.Random;

public class VotingEligibility{

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n){
        int[] ages = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10;
        }
        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for(int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false"; // negative age cannot vote
            } 
			else if (ages[i] >= 18) {
                result[i][1] = "true";  // can vote
            } 
			else {
                result[i][1] = "false"; // cannot vote
            }
        }
        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayResult(String[][] data){
        System.out.println("\nAge\tCan Vote");
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // Generate ages
        int[] ages = generateAges(n);

        // Check voting eligibility
        String[][] votingStatus = checkVotingEligibility(ages);

        // Display result
        displayResult(votingStatus);
        input.close();
    }
}
