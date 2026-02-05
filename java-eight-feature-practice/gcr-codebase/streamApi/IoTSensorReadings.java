package streamApi;
import java.util.*;

public class IoTSensorReadings {
    public static void main(String[] args) {

        List<Double> sensorReadings = Arrays.asList(
            22.5, 45.0, 30.2, 55.8, 18.9, 60.3);

        double threshold = 40.0;

        sensorReadings.stream()

            // filter readings above threshold
            .filter(reading -> reading > threshold)

            // print each filtered reading
            .forEach(reading ->
                System.out.println("High Sensor Reading: " + reading)
            );
    }
}

