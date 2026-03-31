package CSVDataHandling;

import java.io.*;
import java.util.*;

public class MergeTwoCSVFiles {

    public static void main(String[] args) {

        String file1 = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\student1.csv";
        String file2 = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\student2.csv";
        String outputFile = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\studentsMerged.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        try (
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;

            // Read first CSV File
            br1.readLine(); 
            while ((line = br1.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split("\t");
                String id = data[0];
                String name = data[1];
                String age = data[2];

                studentMap.put(id, new String[]{name, age});
            }

            // Write header to new CSV
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            // Read second CSV File
            br2.readLine(); 
            while ((line = br2.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split("\t");
                String id = data[0];
                String marks = data[1];
                String grade = data[2];

                // Merge using ID
                if (studentMap.containsKey(id)) {
                    String[] student = studentMap.get(id);

                    bw.write(id + "," +
                             student[0] + "," +
                             student[1] + "," +
                             marks + "," +
                             grade);
                    bw.newLine();
                }
            }

            System.out.println("CSV files merged successfully!");

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
