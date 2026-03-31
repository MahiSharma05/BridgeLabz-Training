package jsonPractice;
import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
	public static void main(String[] args) {
		JSONObject data = new JSONObject();
		data.put("name", "mahi");
		data.put("age", 22);
		
		String xml = XML.toString(data);
		System.out.println("<XML>" + xml + "/XML");

	}

}
