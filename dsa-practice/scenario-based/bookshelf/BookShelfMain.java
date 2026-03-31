package bookshelf;

import java.util.Scanner;

public class BookShelfMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n=== BookShelf Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Display Catalog");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Genre: ");
                    String genre = input.nextLine();
                    System.out.print("Enter Title: ");
                    String title = input.nextLine();
                    System.out.print("Enter Author: ");
                    String author = input.nextLine();

                    library.addBook(genre, new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter Genre: ");
                    String g = input.nextLine();
                    System.out.print("Enter Book Title: ");
                    String t = input.nextLine();

                    library.borrowBook(g, t);
                    break;

                case 3:
                    library.displayCatalog();
                    break;

                case 4:
                    System.out.println("Exiting BookShelf...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        input.close();
    }
}
