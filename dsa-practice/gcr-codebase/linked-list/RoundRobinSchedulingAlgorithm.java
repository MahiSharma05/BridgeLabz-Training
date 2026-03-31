package linkedList;
import java.util.Scanner;

class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;

    // Add process at end
    public void addProcess(int pid, int burst, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burst, priority);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Process added successfully");
    }

    // Remove process by ID
    private void removeProcess(ProcessNode prev, ProcessNode current) {
        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            tail.next = head;
        } else if (current == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = current.next;
        }
    }

    // Display processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue");
            return;
        }

        ProcessNode temp = head;
        System.out.println("\nCurrent Process Queue:");
        do {
            System.out.println("PID: " + temp.processId +
                    " | Remaining Time: " + temp.remainingTime +
                    " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Round Robin Scheduling
    public void schedule(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule");
            return;
        }

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int completedProcesses = 0;

        ProcessNode current = head;
        ProcessNode prev = tail;

        while (head != null) {
            displayProcesses();

            if (current.remainingTime > timeQuantum) {
                current.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
            } else {
                currentTime += current.remainingTime;
                current.remainingTime = 0;

                current.turnAroundTime = currentTime;
                current.waitingTime = current.turnAroundTime - current.burstTime;

                totalWaitingTime += current.waitingTime;
                totalTurnAroundTime += current.turnAroundTime;
                completedProcesses++;

                System.out.println("Process " + current.processId + " completed");

                removeProcess(prev, current);
                current = prev.next;
                continue;
            }

            prev = current;
            current = current.next;
        }

        System.out.println("\nScheduling Completed");
        System.out.println("Average Waiting Time: " +
                (double) totalWaitingTime / completedProcesses);
        System.out.println("Average Turnaround Time: " +
                (double) totalTurnAroundTime / completedProcesses);
    }
}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        while (true) {
            System.out.println("\nRound Robin Scheduling Menu");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Start Scheduling");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int pid = input.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int burst = input.nextInt();
                    System.out.print("Enter Priority: ");
                    int priority = input.nextInt();
                    scheduler.addProcess(pid, burst, priority);
                    break;

                case 2:
                    scheduler.displayProcesses();
                    break;

                case 3:
                    System.out.print("Enter Time Quantum: ");
                    int tq = input.nextInt();
                    scheduler.schedule(tq);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
