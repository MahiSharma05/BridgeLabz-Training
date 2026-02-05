package streamApi;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class GymMember {
    private String name;
    private LocalDate expiryDate;

    public GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return name + " | Expiry Date: " + expiryDate;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {

        List<GymMember> members = Arrays.asList(
            new GymMember("Rahul", LocalDate.now().plusDays(10)),
            new GymMember("Anita", LocalDate.now().plusDays(40)),
            new GymMember("Vikas", LocalDate.now().plusDays(25)),
            new GymMember("Sneha", LocalDate.now().plusDays(5)),
            new GymMember("Aman", LocalDate.now().plusDays(60))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<GymMember> expiringSoon = members.stream()

            // filter members expiring within next 30 days
            .filter(m -> 
                m.getExpiryDate().isAfter(today) &&
                m.getExpiryDate().isBefore(next30Days)
            )

            .collect(Collectors.toList());

        expiringSoon.forEach(System.out::println);
    }
}

