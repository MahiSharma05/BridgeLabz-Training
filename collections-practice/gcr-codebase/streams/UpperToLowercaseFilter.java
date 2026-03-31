package streams;
import java.io.*;

public class UpperToLowercaseFilter {

	public static void main(String[] args) {
		String sourceFile = "C:\\Users\\sony\\eclipse-workspace\\Collection\\src\\streams\\SourceFile.txt";
		String destinationFile = "C:\\Users\\sony\\eclipse-workspace\\Collection\\src\\streams\\DestinationFile.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(sourceFile));
				BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile,true))){
			int ch;
			while((ch = br.read()) != -1) {
				// Convert uppercase letters to lowercase
				if(Character.isUpperCase(ch)) {
					ch = Character.toLowerCase(ch);
				}
				bw.write(ch);
			}
            System.out.println("File conversion completed successfully.");
		}
		catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }

	}

}