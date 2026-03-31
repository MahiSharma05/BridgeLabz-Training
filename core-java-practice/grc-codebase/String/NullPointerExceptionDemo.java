//Write a program to demonstrate NullPointerException. 

public class NullPointerExceptionDemo {

    // Method to generate NullPointerException
    public static void generateException() {

        String text = null;   
        System.out.println("Length of text: " + text.length());
    }

    // Method to handle NullPointerException using try-catch
    public static void handleException() {

        String text = null;   

        try {
            System.out.println("Length of text: " + text.length());
        } 
		catch (NullPointerException e) {
            System.out.println("NullPointerException occurred!");
            System.out.println("Reason: Attempt to access a method on null object");
        }
    }

    public static void main(String[] args) {

        try {
            generateException();
        } 
		catch (NullPointerException e) {
            System.out.println("Exception occurred in generateException()");
        }

        handleException();
    }
}
