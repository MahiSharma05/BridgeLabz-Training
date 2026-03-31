package scenariio;

import java.util.PriorityQueue;
import java.util.Scanner;

// Custom Exception
class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

// BackupTask class
class BackupTask implements Comparable<BackupTask> {
    String folderPath;
    int priority;
    String time;

    public BackupTask(String folderPath, int priority, String time) {
        this.folderPath = folderPath;
        this.priority = priority;
        this.time = time;
    }

    // Higher priority executes first
    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "Backup Folder: " + folderPath +
               ", Priority: " + priority +
               ", Time: " + time;
    }
}

// Scheduler class
class BackupScheduler {

    private PriorityQueue<BackupTask> queue = new PriorityQueue<>();

    public void scheduleBackup(String path, int priority, String time)
            throws InvalidBackupPathException {

        if (path == null || path.isEmpty() || !path.startsWith("/")) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }

        queue.add(new BackupTask(path, priority, time));
        System.out.println("Backup scheduled successfully.");
    }

    public void executeBackups() {
        if (queue.isEmpty()) {
            System.out.println("No backup tasks to execute.");
            return;
        }

        System.out.println("\nExecuting backup tasks in priority order:");
        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            System.out.println("Executing → " + task);
        }
    }
}

public class FileBackupScheduler {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BackupScheduler scheduler = new BackupScheduler();

        while (true) {
            System.out.println("\n--- File Backup Scheduler ---");
            System.out.println("1. Schedule Backup");
            System.out.println("2. Execute Backups");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter folder path: ");
                        String path = input.nextLine();

                        System.out.print("Enter priority (higher = critical): ");
                        int priority = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter backup time: ");
                        String time = input.nextLine();

                        scheduler.scheduleBackup(path, priority, time);
                        break;

                    case 2:
                        scheduler.executeBackups();
                        break;

                    case 3:
                        System.out.println("Exiting Backup Scheduler.");
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
            catch (InvalidBackupPathException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

