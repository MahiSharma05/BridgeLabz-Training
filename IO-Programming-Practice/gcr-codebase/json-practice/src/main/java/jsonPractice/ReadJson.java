package jsonPractice;
import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {

	public static void main(String[] args) {
		try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootNode = mapper.readTree(new File("src/main/resources/user.json"));

            System.out.println(rootNode);

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
