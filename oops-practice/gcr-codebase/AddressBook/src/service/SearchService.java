package service;

import dao.AddressBookDao;
import model.AddressBook;
import model.Contact;
import java.util.*;
import java.util.stream.Collectors;

public class SearchService {
    private AddressBookDao dao;

    public SearchService(AddressBookDao dao) {
        this.dao = dao;
    }

    // UC 8: Search Person in a City or State across multiple Address Books 
    public List<Contact> searchByCityOrState(String location) {
        List<AddressBook> allBooks = dao.getAllAddressBooks();
        return allBooks.stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(c -> c.getCity().equalsIgnoreCase(location) || c.getState().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    // UC 9: View Persons by City or State [cite: 14]
    // UC 10: Count persons by City or State [cite: 15]
    public Map<String, List<Contact>> viewByCityOrState(String type) {
        List<AddressBook> allBooks = dao.getAllAddressBooks();
        List<Contact> allContacts = allBooks.stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.toList());

        if (type.equalsIgnoreCase("City")) {
            return allContacts.stream().collect(Collectors.groupingBy(Contact::getCity));
        } else {
            return allContacts.stream().collect(Collectors.groupingBy(Contact::getState));
        }
    }
}