//Write a program to create a calculator using switch...case.

import java.util.Scanner;

public class Calculator{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number:");
        double first = input.nextDouble();

        System.out.print("Enter second number:");
        double second = input.nextDouble();

        // Input operator
        System.out.print("Enter operator (+, -, *, /): ");
        String op = input.next();

        // Switch case for calculator
        switch (op){
            case "+":
                System.out.println("Result = "+(first + second));
                break;

            case "-":
                System.out.println("Result = "+ (first - second));
                break;

            case "*":
                System.out.println("Result = "+ (first * second));
                break;

            case "/":
                if(second != 0){
                    System.out.println("Result = "+ (first / second));
                } 
				else{
                    System.out.println("Division by zero is not allowed");
                }
                break;

            default:
                System.out.println("Invalid Operator");
        }
        input.close();
    }
}
