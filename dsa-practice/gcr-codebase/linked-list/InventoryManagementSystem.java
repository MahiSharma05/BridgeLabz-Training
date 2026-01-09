package linkedList;

import java.util.Scanner;

class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private ItemNode head;

    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found!");
    }

    public void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void displayAll() {
        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(ItemNode i) {
        System.out.println("----------------------");
        System.out.println("Item ID: " + i.itemId);
        System.out.println("Name: " + i.itemName);
        System.out.println("Quantity: " + i.quantity);
        System.out.println("Price: ₹" + i.price);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();

        while (true) {
            System.out.println("\nInventory Management ");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Item ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by Item ID");
            System.out.println("7. Search by Item Name");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Display All");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Item ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Item Name: ");
                    String name = input.nextLine();
                    System.out.print("Quantity: ");
                    int qty = input.nextInt();
                    System.out.print("Price: ");
                    double price = input.nextDouble();

                    if (choice == 1)
                        inventory.addAtBeginning(id, name, qty, price);
                    else if (choice == 2)
                        inventory.addAtEnd(id, name, qty, price);
                    else {
                        System.out.print("Position: ");
                        int pos = input.nextInt();
                        inventory.addAtPosition(pos, id, name, qty, price);
                    }
                    break;

                case 4:
                    System.out.print("Item ID: ");
                    inventory.removeById(input.nextInt());
                    break;

                case 5:
                    System.out.print("Item ID: ");
                    int iid = input.nextInt();
                    System.out.print("New Quantity: ");
                    inventory.updateQuantity(iid, input.nextInt());
                    break;

                case 6:
                    System.out.print("Item ID: ");
                    inventory.searchById(input.nextInt());
                    break;

                case 7:
                    System.out.print("Item Name: ");
                    inventory.searchByName(input.nextLine());
                    break;

                case 8:
                    inventory.calculateTotalValue();
                    break;

                case 9:
                    inventory.displayAll();
                    break;

                case 10:
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

