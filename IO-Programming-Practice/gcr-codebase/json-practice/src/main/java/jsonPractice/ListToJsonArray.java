package jsonPractice;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

 class Students{
	public String name;
	public int rollNo;
	public String course;
public Students(String name, int rollNo, String course){
	this.name= name;
	this.rollNo = rollNo;
	this.course = course;
}
}

public class ListToJsonArray {

	public static void main(String[] args) {
		try { 
		   List<Students> student = List.of(new Students("mahi",34,"Java"),
				  new Students("Deepa", 33, "Java"));
           ObjectMapper mapper = new ObjectMapper();
		   System.out.println(mapper.writeValueAsString(student));
        }
		
        catch(Exception e){
        	e.printStackTrace();
        }
	}
}
