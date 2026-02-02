package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\Student.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header row
            br.readLine();

            while ((line = br.readLine()) != null) {

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split(",");

                int marks = Integer.parseInt(columns[3]);

                if (marks > 80) {
                    System.out.println(
                            columns[0] + "\t" +
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
