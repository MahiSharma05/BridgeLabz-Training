package model;

import java.util.ArrayList;
import java.util.List;

// UC 6: Each Address Book has a unique Name [cite: 10]
public class AddressBook {
    private String bookName;
    private List<Contact> contacts;

    public AddressBook(String bookName) {
        this.bookName = bookName;
        this.contacts = new ArrayList<>();
    }

    public String getBookName() {
    	return bookName; 
    	}
    
    // UC 5: Use Collection Class to maintain multiple contact persons
    public List<Contact> getContacts() {
    	return contacts;
    	}
}