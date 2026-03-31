package streamApi;
import java.util.*;

public class EmailNotificationApp {

    public static void main(String[] args) {

        // List of user email addresses
        List<String> emails = Arrays.asList(
            "user1@gmail.com",
            "user2@yahoo.com",
            "user3@outlook.com",
            "user4@company.com"
        );

        // Send notification email to each user
        emails.forEach(email -> sendEmailNotification(email));
    }

    // Method to simulate sending an email
    public static void sendEmailNotification(String email) {
        System.out.println("Sending notification email to: " + email);
    }
}
