package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\studentsMerged.csv";

        // Set to store unique IDs
        Set<String> seenIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header row
            br.readLine();

            System.out.println("Duplicate Records:");
            System.out.println("ID\tName\tAge\tMarks");

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split(",");

                String id = columns[0];

                // If ID already exists → duplicate
                if (!seenIds.add(id)) {
                    System.out.println(columns[0] + "\t" +
                            columns[1] + "\t" +
                            columns[2] + "\t" +
                            columns[3]);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
