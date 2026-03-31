package streamApi;

import java.util.*;
import java.util.stream.*;

class Doctor {
    private String name;
    private String specialty;
    private boolean availableOnWeekend;

    public Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean isAvailableOnWeekend() {
        return availableOnWeekend;
    }

    @Override
    public String toString() {
        return name + " | " + specialty + " | Weekend: " + availableOnWeekend;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Sharma", "Cardiology", true),
            new Doctor("Dr. Gupta", "Neurology", false),
            new Doctor("Dr. Verma", "Orthopedics", true),
            new Doctor("Dr. Singh", "Dermatology", true),
            new Doctor("Dr. Khan", "Cardiology", false)
        );

        List<Doctor> weekendDoctors = doctors.stream()

            // filter: doctors available on weekends
            .filter(Doctor::isAvailableOnWeekend)

            // sort by specialty alphabetically
            .sorted(Comparator.comparing(Doctor::getSpecialty))

            // collect result
            .collect(Collectors.toList());

        weekendDoctors.forEach(System.out::println);
    }
}

