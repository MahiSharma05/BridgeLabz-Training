import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception 
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

public class PhoneContactOrganizer {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Phone Contact Organizer ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        addContact(input);
                        break;
                    case 2:
                        deleteContact(input);
                        break;
                    case 3:
                        searchContact(input);
                        break;
                    case 4:
                        displayContacts();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } 
            catch (InvalidPhoneNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } 
        while (choice != 5);

        input.close();
    }
    // Contact class
    static class Contact {
        String name;
        String phone;

        Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    // List to store contacts
    static ArrayList<Contact> contactList = new ArrayList<>();

    // Validate phone number
    static void validatePhone(String phone) throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                    "Phone number must be exactly 10 digits");
        }
    }

    // Add contact
    static void addContact(Scanner input) throws InvalidPhoneNumberException {
        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = input.nextLine();

        validatePhone(phone);

        // Prevent duplicate phone numbers
        for (Contact c : contactList) {
            if (c.phone.equals(phone)) {
                System.out.println("Duplicate contact! Phone number already exists.");
                return;
            }
        }

        contactList.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    // Delete contact
    static void deleteContact(Scanner input) {
        System.out.print("Enter Phone Number to delete: ");
        String phone = input.nextLine();

        for (Contact c : contactList) {
            if (c.phone.equals(phone)) {
                contactList.remove(c);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Search contact
    static void searchContact(Scanner input) {
        System.out.print("Enter Phone Number to search: ");
        String phone = input.nextLine();

        for (Contact c : contactList) {
            if (c.phone.equals(phone)) {
                System.out.println("Contact Found:");
                System.out.println("Name : " + c.name);
                System.out.println("Phone: " + c.phone);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Display all contacts
    static void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\nContact List:");
        for (Contact c : contactList) {
            System.out.println(c.name + " - " + c.phone);
        }
    }
}
