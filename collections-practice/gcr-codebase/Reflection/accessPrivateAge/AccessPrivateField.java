package accessPrivateAge;

import java.lang.reflect.Field;

public class AccessPrivateField {

    public static void main(String[] args) {

        try {
            // Create object of Person
            Person person = new Person();

            // Get Class object
            Class<?> cls = person.getClass();

            // Get private field 'age'
            Field ageField = cls.getDeclaredField("age");

            // Allow access to private field
            ageField.setAccessible(true);

            // Modify value of 'age'
            ageField.set(person, 30);

            // Retrieve value of 'age'
            int ageValue = (int) ageField.get(person);

            System.out.println("Modified Age: " + ageValue);

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
