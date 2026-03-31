package oopsConcepts;
import java.util.ArrayList;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		ArrayList<LibraryItem> items = new ArrayList<>();

        items.add(new Book(101, "Java Programming", "James Gosling"));
        items.add(new Magazine(202, "Tech Monthly", "Editorial Board"));
        items.add(new DVD(303, "Inception", "Christopher Nolan"));

        System.out.println(".... Library Items ....\n");

        for (LibraryItem item : items) {

            item.getItemDetails();

            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Interface usage
            Reservable r = (Reservable) item;
            r.reserveItem("Mahi");

            System.out.println("...............................\n");
        }
    }

	}
	// Interface 
	interface Reservable {
	    void reserveItem(String borrowerName);
	    boolean checkAvailability();
	}

	// Abstract Class
	abstract class LibraryItem {

	    // Encapsulation
	    private int itemId;
	    private String title;
	    private String author;

	    private String borrowerName;
	    private boolean isAvailable = true;

	    LibraryItem(int itemId, String title, String author){
	        this.itemId = itemId;
	        this.title = title;
	        this.author = author;
	    }

	    public int getItemId() {
	        return itemId;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    // Protected access for subclasses
	    protected boolean isAvailable() {
	        return isAvailable;
	    }

	    protected void setBorrower(String borrower) {
	        this.borrowerName = borrower;
	        this.isAvailable = false;
	    }

	    protected void returnItem() {
	        borrowerName = null;
	        isAvailable = true;
	    }

	    // Abstract method
	    abstract int getLoanDuration();

	    // Concrete method
	    void getItemDetails() {
	        System.out.println("Item ID: " + itemId);
	        System.out.println("Title: " + title);
	        System.out.println("Author: " + author);
	        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
	    }
	}

	// Book
	class Book extends LibraryItem implements Reservable {

	    Book(int id, String title, String author) {
	        super(id, title, author);
	    }

	    int getLoanDuration() {
	        return 14; 
	    }

	    public void reserveItem(String borrowerName) {
	        if (isAvailable()){
	            setBorrower(borrowerName);
	            System.out.println("Book reserved by " + borrowerName);
	        } 
	        else{
	            System.out.println("Book not available");
	        }
	    }

	    public boolean checkAvailability(){
	        return isAvailable();
	    }
	}

	//Magazine 
	class Magazine extends LibraryItem implements Reservable {

	    Magazine(int id, String title, String author) {
	        super(id, title, author);
	    }

	    int getLoanDuration() {
	        return 7;
	    }

	    public void reserveItem(String borrowerName) {
	        if (isAvailable()){
	            setBorrower(borrowerName);
	            System.out.println("Magazine reserved by " + borrowerName);
	        } 
	        else{
	            System.out.println("Magazine not available");
	        }
	    }

	    public boolean checkAvailability() {
	        return isAvailable();
	    }
	}

	// DVD 
	class DVD extends LibraryItem implements Reservable {

	    DVD(int id, String title, String author) {
	        super(id, title, author);
	    }

	    int getLoanDuration() {
	        return 5;
	    }

	    public void reserveItem(String borrowerName) {
	        if (isAvailable()){
	            setBorrower(borrowerName);
	            System.out.println("DVD reserved by " + borrowerName);
	        } 
	        else{
	            System.out.println("DVD not available");
	        }
	    }

	    public boolean checkAvailability() {
	        return isAvailable();
	    }
}
