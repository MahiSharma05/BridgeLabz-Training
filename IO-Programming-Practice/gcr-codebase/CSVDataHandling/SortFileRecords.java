package CSVDataHandling;

import java.io.*;
import java.util.*;

public class SortFileRecords {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\Employee.csv";

        List<String[]> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split(",");
                employees.add(columns);
            }

        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        // Sort
        Collections.sort(employees, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {

                int salaryA = Integer.parseInt(a[3]);
                int salaryB = Integer.parseInt(b[3]);

                // Descending order
                return salaryB - salaryA;
            }
        });

        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("ID\tName\tDepartment\tSalary");

        for (int i = 0; i < 5 && i < employees.size(); i++) {
            String[] emp = employees.get(i);
            System.out.println(
                    emp[0] + "\t" +
                    emp[1] + "\t" +
                    emp[2] + "\t" +
                    emp[3]);
        }
    }
}
