package jsonPractice;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ValidateJsonStructure {
	
	public static boolean isValidJson(String json) {
        try {            
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json);
            return true;
        } 
        catch (Exception e) {
            System.out.println("Invalid JSON syntax: ");
            return false;
        }
    }

	public static void main(String[] args) {
		String Json = "{\"name\":\"Mahi\", \"age\":30}";
        System.out.println("Valid JSON: " + isValidJson(Json));

	}

}
