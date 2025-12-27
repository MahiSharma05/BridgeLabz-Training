//Write a program to return all the characters in a string using the user-defined method,  compare the result with the String built-in toCharArray() method, and display the result.

import java.util.Scanner;

public class charArrayComparison{
 
   // User-defined method to return characters of a string without using toCharArray()
    public static char[] getCharacter(String text){
	    char[] chars = new char[text.length()];
		
		for(int i = 0; i < text.length(); i++){
		    chars[i] = text.charAt(i);
        }
        return chars;		
	}
	
	// Method to compare two character arrays
	public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
	
    public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
		
		System.out.println("Enter String: ");
		String text = input.next();
		
		char[] userDefinedArray = getCharacter(text);

        // Built-in method
        char[] builtInArray = text.toCharArray();

        boolean result = compareCharArrays(userDefinedArray, builtInArray);

        System.out.println("Characters using user-defined method: ");
        for (char c : userDefinedArray) {
            System.out.println(c + " ");
        }
		System.out.println();

        System.out.print("Characters using toCharArray(): ");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }

        System.out.println();
        System.out.println("Are both character arrays equal? " + result);

        input.close();
	}
}	
