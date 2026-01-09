package linkedList;
import java.util.Scanner;

class TextStateNode {
    String content;
    TextStateNode prev;
    TextStateNode next;

    TextStateNode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditorHistory {
    private TextStateNode head;
    private TextStateNode tail;
    private TextStateNode current;
    private int size;
    private final int MAX_SIZE = 10;

    // Add new text state
    public void addState(String content) {
        TextStateNode newNode = new TextStateNode(content);

        // If undo was used, remove redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newNode;
            size = 1;
        } 
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
            size++;
        }

        // Maintain history limit
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text state added");
    }

    // Undo operation
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed");
        displayCurrentState();
    }

    // Redo operation
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }
        current = current.next;
        System.out.println("Redo performed");
        displayCurrentState();
    }

    // Display current text state
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("Editor is empty");
            return;
        }
        System.out.println("Current Text:");
        System.out.println(current.content);
    }

    // Display full history (for understanding)
    public void displayHistory() {
        if (head == null) {
            System.out.println("No history available");
            return;
        }

        TextStateNode temp = head;
        System.out.println("\nText History:");
        while (temp != null) {
            if (temp == current) {
                System.out.println("-> " + temp.content + " (current)");
            }
            else {
                System.out.println("   " + temp.content);
            }
            temp = temp.next;
        }
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TextEditorHistory editor = new TextEditorHistory();

        while (true) {
            System.out.println("\nUndo / Redo Text Editor");
            System.out.println("1. Type / Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = input.nextLine();
                    editor.addState(text);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrentState();
                    break;

                case 5:
                    editor.displayHistory();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
