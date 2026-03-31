package browserbuddy;

import java.util.Scanner;

public class BrowserBuddyApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BrowserTab tab = new BrowserTab();
        ClosedTabStack closedTabs = new ClosedTabStack();

        int choice;

        do {
            System.out.println("\n=== BrowserBuddy Menu ===");
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Close Current Tab");
            System.out.println("5. Restore Closed Tab");
            System.out.println("6. Show Current Page");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter URL: ");
                    String url = input.nextLine();
                    tab.visitPage(url);
                    break;

                case 2:
                    tab.back();
                    break;

                case 3:
                    tab.forward();
                    break;

                case 4:
                    System.out.print("Enter URL to close: ");
                    String closeUrl = input.nextLine();
                    closedTabs.closeTab(closeUrl);
                    break;

                case 5:
                    String restored = closedTabs.restoreTab();
                    if (restored != null) {
                        tab.visitPage(restored);
                        System.out.println("Restored Tab: " + restored);
                    }
                    break;

                case 6:
                    tab.displayCurrentPage();
                    break;

                case 7:
                    System.out.println("Exiting BrowserBuddy...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        input.close();
    }
}
