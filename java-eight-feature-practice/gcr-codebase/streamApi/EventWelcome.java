package streamApi;
import java.util.*;

public class EventWelcome {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
            "Rahul",
            "Mahi",
            "Mansi",
            "Heena",
            "Jyoti"
        );

        // forEach with lambda expression
        attendees.forEach(name ->
            System.out.println("Welcome to the event, " + name)
        );
    }
}

