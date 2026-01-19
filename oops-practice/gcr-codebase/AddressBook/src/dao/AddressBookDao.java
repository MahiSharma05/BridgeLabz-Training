package dao;
import model.AddressBook;
import model.Contact;
import java.util.*;

public class AddressBookDao {
	
	// UC 6: Maintain Dictionary of Address Book name to Address Book
	private static Map<String, AddressBook> addressBookSystem = new HashMap<>();
	
	// Create
	public void createAddressBook(AddressBook addressBook) {
		addressBookSystem.put(addressBook.getBookName(), addressBook);
	}

	public void addContactToBook(String bookName, Contact contact) {
		addressBookSystem.get(bookName).getContacts().add(contact);
	}
	
	// Read
	public AddressBook getAddressBook(String bookName) {
		return addressBookSystem.get(bookName);
	}
	
	public boolean doesBookExist(String bookName) {
		return addressBookSystem.containsKey(bookName);
	}
	
	public List<AddressBook> getAllAddressBooks(){
		return new ArrayList<>(addressBookSystem.values());
	}
	
	// Update 
	public void updateContact(String bookName, int index, Contact contact) {
		addressBookSystem.get(bookName).getContacts().set(index, contact);
	}
	
	// Delete
	public void deleteContact(String bookName, Contact contact) {
		addressBookSystem.get(bookName).getContacts().remove(contact);
	}
}
