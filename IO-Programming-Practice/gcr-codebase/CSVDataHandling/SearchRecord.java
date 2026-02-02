package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {

	public static void main(String[] args) {
		 String filePath = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\Employee.csv";

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

	                String name = columns[1];

	                if (name.equalsIgnoreCase("Rahul")) {
	                    System.out.println( columns[2] + "\t" +columns[3]);
	                }
	            }

	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
