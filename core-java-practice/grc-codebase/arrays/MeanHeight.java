//Create a program to find the mean height of players present in a football team.

import java.util.Scanner;

public class MeanHeight{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // array to store heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0;

        // input for heights
        for(int i = 0; i < heights.length; i++){
            System.out.print("Enter height of player "+ (i + 1)+ ": ");
            heights[i] = input.nextDouble();
        }

        // Calculate sum of heights
        for(int i = 0; i < heights.length; i++){
            sum = sum + heights[i];
        }

        // Calculate mean
        double mean = sum / heights.length;

        // Display mean height
        System.out.println("\nMean height of the football team = "+ mean);
        input.close();
    }
}
