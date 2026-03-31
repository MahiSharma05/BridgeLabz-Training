package smartenergy;

import java.util.*;

public class EnergyMonitor {

    private Map<Date, List<Double>> energyData = new HashMap<>();

    // Add energy reading
    public void addReading(Date date, double reading)
            throws InvalidEnergyReadingException {

        if (reading < 0) {
            throw new InvalidEnergyReadingException(
                    "Energy reading cannot be negative.");
        }

        energyData.putIfAbsent(date, new ArrayList<>());
        energyData.get(date).add(reading);
    }

    // Calculate daily average
    public double calculateDailyAverage(Date date) {

        List<Double> readings = energyData.get(date);

        if (readings == null || readings.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (double r : readings) {
            sum += r;
        }

        return sum / readings.size();
    }

    // Calculate monthly average
    public double calculateMonthlyAverage(int month, int year) {

        double total = 0;
        int count = 0;

        Calendar cal = Calendar.getInstance();

        for (Map.Entry<Date, List<Double>> entry : energyData.entrySet()) {

            cal.setTime(entry.getKey());

            int entryMonth = cal.get(Calendar.MONTH);
            int entryYear = cal.get(Calendar.YEAR);

            if (entryMonth == month && entryYear == year) {

                for (double value : entry.getValue()) {
                    total += value;
                    count++;
                }
            }
        }

        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    // reporting method
    public void generateReport() {

        System.out.println("\n--- Energy Consumption Report ---");

        for (Date date : energyData.keySet()) {
            double avg = calculateDailyAverage(date);
            System.out.println(date + " -> Daily Avg: " + avg);
        }
    }
}
