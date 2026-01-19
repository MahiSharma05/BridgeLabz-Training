package service;

import dao.AddressBookDao;
import model.AddressBook;
import model.Contact;
import java.util.List;

public class AddressBookService {
    private AddressBookDao dao;

    public AddressBookService(AddressBookDao dao) {
        this.dao = dao;
    }

    // UC 6: Add new Address Book [cite: 10]
    public void createAddressBook(String name) {
        if (dao.doesBookExist(name)) {
            System.out.println("Address Book already exists.");
            return;
        }
        AddressBook newBook = new AddressBook(name);
        dao.createAddressBook(newBook);
    }

    // UC 2: Add a new Contact [cite: 6]
    // UC 7: Duplicate Check [cite: 11]
    public String addContact(String bookName, Contact contact) {
        if (!dao.doesBookExist(bookName)) return "Address Book not found.";

        AddressBook book = dao.getAddressBook(bookName);
        List<Contact> contactList = book.getContacts();

        // Check for Duplicate Entry
        // UC 7: Override equals method to check for Duplicate [cite: 11]
        boolean isDuplicate = contactList.stream().anyMatch(c -> c.equals(contact));
        
        if (isDuplicate) {
            return "Duplicate Entry! Person already exists.";
        }

        // If valid, call DAO to save
        dao.addContactToBook(bookName, contact);
        return "Contact added successfully.";
    }

    // UC 3: Edit existing contact
    public String editContact(String bookName, String firstName, String lastName, Contact newDetails) {
        if (!dao.doesBookExist(bookName)) return "Address Book not found.";

        AddressBook book = dao.getAddressBook(bookName);
        List<Contact> contactList = book.getContacts();

        for (int i = 0; i < contactList.size(); i++) {
            Contact c = contactList.get(i);
            if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)) {
                // Keep original names to maintain identity, update other details
                newDetails.setFirstName(firstName); 
                newDetails.setLastName(lastName);
                
                dao.updateContact(bookName, i, newDetails);
                return "Contact updated successfully.";
            }
        }
        return "Contact not found.";
    }

    // UC 4: Delete a person 
    public String deleteContact(String bookName, String firstName, String lastName) {
        if (!dao.doesBookExist(bookName)) return "Address Book not found.";

        AddressBook book = dao.getAddressBook(bookName);
        Contact contactToDelete = book.getContacts().stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);

        if (contactToDelete != null) {
            dao.deleteContact(bookName, contactToDelete);
            return "Contact deleted successfully.";
        }
        return "Contact not found.";
    }
}