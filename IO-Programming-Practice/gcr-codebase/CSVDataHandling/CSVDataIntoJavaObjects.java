package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataIntoJavaObjects {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\Student.csv";

        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header row
            br.readLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split(",");

                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                int age = Integer.parseInt(columns[2]);
                int marks = Integer.parseInt(columns[3]);

                // Convert row into Student object
                Student student = new Student(id, name, age, marks);

                // Add to list
                studentList.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print all Student objects
        System.out.println("ID\tName\tAge\tMarks");
        for (Student s : studentList) {
            s.display();
        }
    }
}
