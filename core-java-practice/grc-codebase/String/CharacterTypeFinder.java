//Write a program to find vowels and consonants in a string and display the character type - Vowel, Consonant, or Not a Letter

import java.util.Scanner;

public class CharacterTypeFinder{

    // Method to check character type
    public static String checkCharacter(char ch){

        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        // Check if letter
        if(ch >= 'a' && ch <= 'z'){
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } 
			else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
    // Method to find character type and return 2D array
    public static String[][] findCharacterTypes(String text){
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacter(ch);
        }
        return result;
    }
    // Method to display 2D array in tabular format
    public static void displayResult(String[][] data) {

        System.out.println("\nCharacter\tType");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[][] result = findCharacterTypes(text);
        displayResult(result);
        input.close();
    }
}
