package practice2;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ScoringEngine {
	public static String evaluate(String input) {
		Pattern pattern = Pattern.compile("\\[(SUM|MUL|MAX|MIN):([^\\]]*)\\]");
		Matcher matcher = pattern.matcher(input);
		StringBuffer result = new StringBuffer();
        while(matcher.find()){
        	String operation = matcher.group(1);
    		String exprassion = matcher.group(2);
    		
    		// validate expression
    		if(!exprassion.matches("-?(0|[1-9]\\d*)(,-?(0|[1-9]\\d*))+")) {
    			matcher.appendReplacement(result, "ERROR");
    			continue;
    		}
    		String[] nums = exprassion.split(",");
    		int[] arr = new int[nums.length];
    		for(int i = 0; i < nums.length; i++) {
    			arr[i] = Integer.parseInt(nums[i]);
    		}
    		int value = 0 ;
    		switch(operation) {
    			case "SUM":
    				value = 0;
    				for(int i : arr) {
    					value += i;	
    				}
    				break;
    			case "MUL":
    			       value = 1;
    			       for(int i : arr) {
    				       value *= i;
    		        	}
    			       break;
    			case "MAX":
    				value = arr[0];
    				for(int i : arr) {
    					value = Math.max(value, i);
    				}
    				break;
    			case "MIN":
    				value = arr[0];
    				for(int i : arr) {
    					value = Math.min(value, i);
    				}
    				break;    				
    		}
    		matcher.appendReplacement(result, String.valueOf(value));
        }
        matcher.appendTail(result);
        String finalResult = result.toString().replaceAll("\\[[^\\]]*$" , "ERROR");
		return finalResult;
	}

	public static void main(String[] args) {
		System.out.println("input");
		Scanner sc =new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			System.out.println(evaluate(input));
		}

	}

}
