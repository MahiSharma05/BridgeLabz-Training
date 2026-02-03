package jsonPractice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.*;
import java.util.*;

public class FilterJson {

    public static void main(String[] args) {
        try {
            String json = "[{\"name\":\"Moni\", \"age\":30},{\"name\":\"heena\", \"age\":20} , {\"name\":\"heena\", \"age\":29}]";

            ObjectMapper mapper = new ObjectMapper();

            JsonNode rootNode = mapper.readTree(json);

            List<JsonNode> filteredList = new ArrayList<>();

            for (JsonNode node : rootNode) {
                if (node.get("age").asInt() > 25) {
                    filteredList.add(node);
                }
            }
            System.out.println(mapper.writeValueAsString(filteredList));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
