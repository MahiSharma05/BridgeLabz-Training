package service;

import dao.AddressBookDao;
import model.AddressBook;
import model.Contact;
import java.util.*;
import java.util.stream.Collectors;

public class SortService {
    private AddressBookDao dao;

    public SortService(AddressBookDao dao) {
        this.dao = dao;
    }

    // UC 11: Sort by Person's name [cite: 16]
    // UC 12: Sort by City, State, or Zip [cite: 17]
    public List<Contact> sortContacts(String bookName, String criteria) {
        if (!dao.doesBookExist(bookName)) return new ArrayList<>();

        List<Contact> contacts = dao.getAddressBook(bookName).getContacts();
        Comparator<Contact> comparator;

        switch (criteria.toLowerCase()) {
            case "name":
                comparator = Comparator.comparing(c -> (c.getFirstName() + " " + c.getLastName()));
                break;
            case "city":
                comparator = Comparator.comparing(Contact::getCity);
                break;
            case "state":
                comparator = Comparator.comparing(Contact::getState);
                break;
            case "zip":
                comparator = Comparator.comparing(Contact::getZip);
                break;
            default:
                return contacts;
        }

        return contacts.stream().sorted(comparator).collect(Collectors.toList());
    }
}