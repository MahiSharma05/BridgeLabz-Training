package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadandCountRows {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\Employee.csv";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header row
            br.readLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split(",");

                System.out.println(
                        columns[0] + "\t" +
                        columns[1] + "\t" +
                        columns[2] + "\t" +
                        columns[3]
                );

                count++; 
            }

            System.out.println("\nTotal records (excluding header): " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
