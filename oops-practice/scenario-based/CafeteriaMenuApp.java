import java.util.Scanner;

public class CafeteriaMenuApp {

    public static void main(String[] args) {

        // Fixed menu items
        String[] menuItems = {"Idli","Dosa","Pizza","Poha","Momos","Fried Rice","Burger","Veg Sandwich","Tea","Coffee"};

        Scanner input = new Scanner(System.in);

        // Display menu
        displayMenu(menuItems);

        // User input
        System.out.print("\nEnter item index to order: ");
        int choice = input.nextInt();

        // Get selected item
        String selectedItem = getItemByIndex(menuItems, choice);

        System.out.println("\nYou selected: " + selectedItem);

        input.close();
    }
    //display menu
    public static void displayMenu(String[] menu) {
        System.out.println("...Cafeteria Menu ...");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i+1  + " : " + menu[i]);
        }
    }

    //get item by index
    public static String getItemByIndex(String[] menu, int index) {
        if (index >= 1 && index <= menu.length) {
            return menu[index-1];
        } else {
            return "Invalid selection!";
        }
    }
}
