package smartenergy;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        EnergyMonitor monitor = new EnergyMonitor();

        try {

            Calendar cal = Calendar.getInstance();

           
            cal.set(2025, Calendar.JANUARY, 10);
            Date date1 = cal.getTime();

            monitor.addReading(date1, 10.5);
            monitor.addReading(date1, 12.3);
            monitor.addReading(date1, 9.8);

           
            cal.set(2025, Calendar.JANUARY, 11);
            Date date2 = cal.getTime();

            monitor.addReading(date2, 8.0);
            monitor.addReading(date2, 7.5);

            // invalid reading
            

            monitor.generateReport();

            double monthlyAvg =
                    monitor.calculateMonthlyAverage(Calendar.JANUARY, 2025);

            System.out.println("\nMonthly Average (Jan 2025): "
                    + monthlyAvg);

        } catch (InvalidEnergyReadingException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
