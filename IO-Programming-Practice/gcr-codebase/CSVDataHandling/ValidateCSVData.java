package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidateCSVData {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\PersonDetails.csv";

        // Regex patterns
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "\\d{10}";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header row
            br.readLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split("\t");

                String name = columns[0];
                String email = columns[1];
                String phoneNo = columns[2];

                boolean validEmail = email.matches(emailRegex);
                boolean validPhone = phoneNo.matches(phoneRegex);

                if (!validEmail || !validPhone) {
                    System.out.println("Invalid Row -> " + name + "\t" + email + "\t" + phoneNo);

                    if (!validEmail) {
                        System.out.println("Invalid Email Format");
                    }
                    if (!validPhone) {
                        System.out.println("Phone number must be 10 digits");
                    }
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
