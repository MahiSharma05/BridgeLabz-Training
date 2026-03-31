package jsonPractice;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
class Car {
    public String brand;
    public String model;
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
}
public class ObjectIntoJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car("Ford", "Tata Punch");
            // Convert Java Object to JSON String
            String jsonString = objectMapper.writeValueAsString(car);
            System.out.println(jsonString);
        }
        catch(Exception e){
        	e.printStackTrace();
        	
        }
    }
}