package CSVDataHandling;

import java.io.*;

public class ModifyFile {

    public static void main(String[] args) {

        String inputFile = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\Employee.csv";
        String outputFile = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\EmployeeUpdated.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;

            // Read & write header
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split(",");

                String department = columns[2];
                int salary = Integer.parseInt(columns[3]);

                // Increase salary 
                if (department.equalsIgnoreCase("IT")) {
                    salary = (int)(salary * 1.10);
                }

                // Write updated row
                bw.write(columns[0] + "," +
                         columns[1] + "," +
                         columns[2] + "," +
                         salary);
                bw.newLine();
            }

            System.out.println("Salary updated and saved to EmployeeUpdated.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
