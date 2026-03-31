package linkedList;

import java.util.Scanner;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskScheduler {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode current;

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            current = head;
        } 
        else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        System.out.println("Task added at beginning.");
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            current = head;
        } 
        else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Task added at end.");
    }

    // Add at specific position (1-based)
    public void addAtPosition(int position, int id, String name, int priority, String date) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        TaskNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        TaskNode newNode = new TaskNode(id, name, priority, date);
        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }

        System.out.println("Task added at position " + position);
    }

    // Remove by Task ID
    public void removeByTaskId(int id) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = tail;

        do {
            if (temp.taskId == id) {
                if (temp == head && temp == tail) {
                    head = tail = current = null;
                } else {
                    prev.next = temp.next;
                    if (temp == head) head = temp.next;
                    if (temp == tail) tail = prev;
                    if (temp == current) current = temp.next;
                }
                System.out.println("Task removed successfully.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } 
        while (temp != head);

        System.out.println("Task not found!");
    }

    // View current task and move to next
    public void viewCurrentAndNext() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with this priority.");
        }
    }

    private void displayTask(TaskNode t) {
        System.out.println("--------------------------");
        System.out.println("Task ID: " + t.taskId);
        System.out.println("Task Name: " + t.taskName);
        System.out.println("Priority: " + t.priority);
        System.out.println("Due Date: " + t.dueDate);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        while (true) {
            System.out.println("\nTask Scheduler ");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Task ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Task Name: ");
                    String name = input.nextLine();
                    System.out.print("Priority: ");
                    int priority = input.nextInt();
                    input.nextLine();
                    System.out.print("Due Date: ");
                    String date = input.nextLine();

                    if (choice == 1)
                        scheduler.addAtBeginning(id, name, priority, date);
                    else if (choice == 2)
                        scheduler.addAtEnd(id, name, priority, date);
                    else {
                        System.out.print("Position: ");
                        int pos = input.nextInt();
                        scheduler.addAtPosition(pos, id, name, priority, date);
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID: ");
                    scheduler.removeByTaskId(input.nextInt());
                    break;

                case 5:
                    scheduler.viewCurrentAndNext();
                    break;

                case 6:
                    scheduler.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority: ");
                    scheduler.searchByPriority(input.nextInt());
                    break;

                case 8:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

