package Collectors;
import java.util.*;
import java.util.stream.*;

class Student{
	String name;
	String grade;
public Student(String name, String grade) {
	this.name= name;
	this.grade = grade;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}

}
public class StudentResult {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("Mahi", "A"),
				new Student("Deepa", "B"),
				new Student("Rahul", "C"),
				new Student("Mansi","A"),
				new Student("Heena", "C"));
		
		// Group Students by grade and collect names
		Map<String, List<String>> groupedStudents = students.stream()
				.collect(Collectors.groupingBy(
						Student::getGrade,
						Collectors.mapping(Student::getName, Collectors.toList())));
		
		// Final result
		groupedStudents.forEach((grades , names) -> System.out.println("Grades: " + grades + " Name: " + names));
		

	}

}
