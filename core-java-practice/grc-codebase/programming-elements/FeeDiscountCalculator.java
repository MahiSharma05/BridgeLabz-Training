/*The University is charging the student fee for the course. The University is willing to offer a discount. Write a program to find the discounted amount and discounted price 
the student will pay for the course.take user input for Student Fee and University Discount.*/

import java.util.Scanner;

class FeeDiscountCalculator{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int fee = input.nextInt();              
        int discountPercent = input.nextInt();  
        int discount = (fee * discountPercent) / 100;
        int finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount +" and final discounted fee is INR " + finalFee);
    }
}
