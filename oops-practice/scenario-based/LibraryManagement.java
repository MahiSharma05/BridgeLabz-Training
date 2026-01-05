package scenario;

public class LibraryManagement {
	
	// Arrays to store book data
	static String[] titles = {"Java Programming" , "Python Programming" , "Data Structures" , "Web Development" };
	static String[] authors = {"James Gosling" , "Mark Allen" , "Guido Van Rossum" , "John Doe"};
	static boolean[] isAvailable = { true , true , true , true};
	
	// Methods to display all Books
	static void displayBooks() {
		System.out.println("Library Books");
        for(int i = 0; i < titles.length; i++) {
        	System.out.println((i + 1) + " . " + titles[i] + " | Author:" + authors[i] + " | Status:" + (isAvailable[i] ? "Available" : "Checked out"));
        }
	}
	
	// Method to search book by partial title
	static void searchBook(String keyword) {
		System.out.println("\nSearch Results for \"" + keyword + "\":");
        boolean found = false;

        for (int i = 0; i < titles.length; i++) {
            if (titles[i].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(
                    titles[i] + " | Author: " + authors[i] +
                    " | Status: " + (isAvailable[i] ? "Available" : "Checked Out")
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }
	
	// Method to checkout a book
    static void checkoutBook(int index) {
        if (index < 0 || index >= titles.length) {
            System.out.println("Invalid book selection.");
            return;
        }

        if (isAvailable[index]) {
            isAvailable[index] = false;
            System.out.println("Book checked out: " + titles[index]);
        } else {
            System.out.println("Book is already checked out.");
        }
    }
    
 // Method to return a book
    static void returnBook(int index) {
        if (index < 0 || index >= titles.length) {
            System.out.println("Invalid book selection.");
            return;
        }

        isAvailable[index] = true;
        System.out.println("Book returned: " + titles[index]);
    }

	public static void main(String[] args) {
		displayBooks();

        searchBook("java");

        checkoutBook(0);   

        displayBooks();

        returnBook(0);

        displayBooks();
		

	}

}
