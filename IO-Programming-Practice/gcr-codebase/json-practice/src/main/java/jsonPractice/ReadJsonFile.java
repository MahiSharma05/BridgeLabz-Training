package jsonPractice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootNode = mapper.readTree(new File("src/main/resources/user.json"));

            // Extract specific fields
            String name = rootNode.get("Name").asText();
            String email = rootNode.get("Email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

