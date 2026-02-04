package LambdaExpressions;
import java.util.*;
import java.util.function.*;
class Alert {
    String message;
    String type;   

    Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String toString() {
        return type + " ALERT: " + message;
    }
}


public class NotificationFiltering {

	public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
                new Alert("Patient temperature normal", "NORMAL"),
                new Alert("Blood pressure rising", "WARNING"),
                new Alert("Heart rate critical", "EMERGENCY")
        );

        // Predicate to show only emergency alerts
        Predicate<Alert> emergencyOnly =
                alert -> alert.type.equals("EMERGENCY");

        System.out.println("Emergency Alerts:");
        alerts.stream()
              .filter(emergencyOnly)
              .forEach(System.out::println);

        // Predicate to show warning and emergency alerts
        Predicate<Alert> warningAndEmergency =
                alert -> alert.type.equals("WARNING") || alert.type.equals("EMERGENCY");

        System.out.println("\nWarning & Emergency Alerts:");
        alerts.stream()
              .filter(warningAndEmergency)
              .forEach(System.out::println);

	}

}
