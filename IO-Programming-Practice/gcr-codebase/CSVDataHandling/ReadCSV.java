package CSVDataHandling;
import java.io.*;
import java.util.*;
public class ReadCSV {

	public static void main(String[] args) {
		String filePath = "Student.csv";
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sony\\eclipse-workspace\\IOProgramming\\src\\CSVDataHandling\\Student.csv"))){
			String line;
			while((line = br.readLine()) != null) {
				String[] columns = line.split("\t");
				System.out.println(columns[0] + "\t" + columns[1] + "\t" + columns[2] + "\t" + columns[3]);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
