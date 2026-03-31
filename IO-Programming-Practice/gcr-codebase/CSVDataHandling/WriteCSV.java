package CSVDataHandling;
import java.util.*;
import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\Employee.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("101,Rahul,Finance,62000\n");
            writer.write("102,Mahi,Sales,58000\n");
            writer.write("103,Sumit,Finance,78000\n");
            writer.write("104,Aditya,Sales,98000\n");
            writer.write("105,Mansi,Finance,8000\n");
            writer.write("106,Monika,Sales,88000\n");


            System.out.println("CSV file written successfully!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
