package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLargeCSVFile {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "C:\\Users\\sony\\large_file.csv";

        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header row
            br.readLine();

            List<String> batch = new ArrayList<>(CHUNK_SIZE);

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                batch.add(line);

                // Process when batch reaches 100 lines
                if (batch.size() == CHUNK_SIZE) {
                    totalRecords += processBatch(batch);
                    batch.clear(); 
                }
            }

            // Process remaining lines 
            if (!batch.isEmpty()) {
                totalRecords += processBatch(batch);
            }

            System.out.println("Total records processed: " + totalRecords);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to process one chunk
    private static int processBatch(List<String> batch) {

        System.out.println("Processed batch of size: " + batch.size());

        return batch.size();
    }
}
