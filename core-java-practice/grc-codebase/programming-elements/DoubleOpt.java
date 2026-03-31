//Write an DoubleOperation program by taking a, b, and c as input values and print the following Double operations a + b *c, a * b + c, c + a / b, and a % b + c. using precedence of the operators. 

import java.util.Scanner;

class DoubleOpt{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();   
        double b = input.nextDouble();   
        double c = input.nextDouble();   
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;
        System.out.println("The results of Double Operations are " +result1 + ", " +result2 + ", " +result3 + ", and " +result4);
    }
}
