//Write a program to input marks and 3 subjects physics, chemistry and maths. Compute the percentage and then calculate the grade

import java.util.Scanner;

public class StudentGrade{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Physics marks:");
        int physics = input.nextInt();

        System.out.print("Enter Chemistry marks:");
        int chemistry = input.nextInt();

        System.out.print("Enter Maths marks:");
        int maths = input.nextInt();

        // Calculate total and percentage
        int total = physics + chemistry + maths;
        double percentage = total / 3.0;

        System.out.println("\nAverage Marks:" + percentage);

        // Grade calculation
        if(percentage >= 80){
            System.out.println("Grade: A");
            System.out.println("Remarks: Level 4, above agency-normalized standards");
        } 
        else if(percentage >= 70){
            System.out.println("Grade: B");
            System.out.println("Remarks: Level 3, at agency-normalized standards");
        } 
        else if(percentage >= 60){
            System.out.println("Grade: C");
            System.out.println("Remarks: Level 2, below but approaching agency-normalized standards");
        } 
        else if(percentage >= 50){
            System.out.println("Grade: D");
            System.out.println("Remarks: Level 1, well below agency-normalized standards");
        } 
        else if(percentage >= 40){
            System.out.println("Grade: E");
            System.out.println("Remarks: Level 1-, too below agency-normalized standards");
        } 
        else{
            System.out.println("Grade: R");
            System.out.println("Remarks: Remedial standards");
        }
        input.close();
    }
}
