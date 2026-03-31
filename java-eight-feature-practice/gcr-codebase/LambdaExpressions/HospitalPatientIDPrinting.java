package LambdaExpressions;
import java.util.*;

public class HospitalPatientIDPrinting {
	public static void main(String[] args) {

        List<String> patientIds = Arrays.asList(
                "PID101", "PID102", "PID103", "PID104"
        );

        // Printing patient IDs using method reference
        patientIds.forEach(System.out::println);
    }

}
