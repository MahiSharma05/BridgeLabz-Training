package jsonPractice;

import org.json.JSONObject;

public class MergetwoJSON {
	public static void mergeJson(JSONObject jsonObject1 , JSONObject jsonObject2) {
		JSONObject merge = new JSONObject(jsonObject1.toString());
		for(String key : jsonObject2.keySet()) {
			merge.put(key,jsonObject2.get(key));
		}
		System.out.println(merge.toString());
	}

	public static void main(String[] args) {
		
		JSONObject jsonObject1 = new JSONObject();

        // Add simple fields
        jsonObject1.put("name", "Mahi Sharma");
        jsonObject1.put("age", 22);
        
        JSONObject jsonObject2 = new JSONObject();

        // Add simple fields
        jsonObject2.put("address", "Gla");
        jsonObject2.put("pinCode", 2345562);
        
        mergeJson(jsonObject1,jsonObject2);

	}
}
