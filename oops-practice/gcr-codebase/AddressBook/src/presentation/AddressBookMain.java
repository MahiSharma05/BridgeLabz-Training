package presentation;
import dao.AddressBookDao;
import model.Contact;
import service.AddressBookService;
import service.SearchService;
import service.SortService;
import java.util.*;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Initialize DAO 
        AddressBookDao dao = new AddressBookDao();

        // Initialize Services
        AddressBookService crudService = new AddressBookService(dao);
        SearchService searchService = new SearchService(dao);
        SortService sortService = new SortService(dao);

        System.out.println("Welcome to Address Book System"); 
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Create Address Book ");
            System.out.println("2. Add Contact ");
            System.out.println("3. Edit Contact ");
            System.out.println("4. Delete Contact ");
            System.out.println("5. Search by City/State");
            System.out.println("6. View & Count by City/State ");
            System.out.println("7. Sort Contacts ");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");
            
            int choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Name for new Address Book: ");
                    crudService.createAddressBook(input.nextLine());
                    System.out.println("Address Book created.");
                    break;
                case 2:
                    System.out.print("Enter Address Book Name: ");
                    String book = input.nextLine();
                    System.out.print("First Name: ");
                    String fn = input.nextLine();
                    System.out.print("Last Name: "); 
                    String ln = input.nextLine();
                    System.out.print("Address: ");
                    String addr = input.nextLine();
                    System.out.print("City: ");
                    String city = input.nextLine();
                    System.out.print("State: ");
                    String state = input.nextLine();
                    System.out.print("Zip: "); 
                    String zip = input.nextLine();
                    System.out.print("Phone: ");
                    String ph = input.nextLine();
                    System.out.print("Email: ");
                    String em = input.nextLine();
                    
                    Contact c = new Contact(fn, ln, addr, city, state, zip, ph, em);
                    System.out.println(crudService.addContact(book, c));
                    break;
                case 3:
                    System.out.print("Address Book Name: "); String bEdit = input.nextLine();
                    System.out.print("Enter First Name of person to edit: "); String fEdit = input.nextLine();
                    System.out.print("Enter Last Name: "); String lEdit = input.nextLine();
                    
                    System.out.println("Enter NEW Details (Address, City, State, Zip, Phone, Email):");
                    Contact newDetails = new Contact(fEdit, lEdit, input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
                    System.out.println(crudService.editContact(bEdit, fEdit, lEdit, newDetails));
                    break;
                case 4:
                    System.out.print("Address Book Name: "); String bDel = input.nextLine();
                    System.out.print("First Name: "); String fDel = input.nextLine();
                    System.out.print("Last Name: "); String lDel = input.nextLine();
                    System.out.println(crudService.deleteContact(bDel, fDel, lDel));
                    break;
                case 5:
                    System.out.print("Enter City or State: ");
                    List<Contact> results = searchService.searchByCityOrState(input.nextLine());
                    if(results.isEmpty()) System.out.println("No contacts found.");
                    else results.forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("View by 'City' or 'State'? ");
                    Map<String, List<Contact>> viewMap = searchService.viewByCityOrState(input.nextLine());
                    for (Map.Entry<String, List<Contact>> entry : viewMap.entrySet()) {
                        System.out.println("Location: " + entry.getKey() + " | Count: " + entry.getValue().size());
                        entry.getValue().forEach(con -> System.out.println(" - " + con));
                    }
                    break;
                case 7:
                    System.out.print("Address Book Name: ");
                    String bSort = input.nextLine();
                    System.out.print("Sort by (name/city/state/zip): "); String criterion = input.nextLine();
                    List<Contact> sorted = sortService.sortContacts(bSort, criterion);
                    sorted.forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}