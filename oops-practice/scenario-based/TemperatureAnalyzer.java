package scenario;

public class TemperatureAnalyzer {

    // Method to find hottest and coldest day
    static void findHottestAndColdestDay(float[][] temp) {
        int hottestDay = 0;
        int coldestDay = 0;

        float maxTemp = temp[0][0];
        float minTemp = temp[0][0];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (temp[i][j] > maxTemp) {
                    maxTemp = temp[i][j];
                    hottestDay = i;
                }
                if (temp[i][j] < minTemp) {
                    minTemp = temp[i][j];
                    coldestDay = i;
                }
            }
        }

        System.out.println("Hottest Day: Day " + (hottestDay + 1) +  " with temperature " + maxTemp);
        System.out.println("Coldest Day: Day " + (coldestDay + 1) +  " with temperature " + minTemp);
    }

    // Method to calculate average temperature per day
    static void averageTemperaturePerDay(float[][] temp) {
        for (int i = 0; i < temp.length; i++) {
            float sum = 0;
            for (int j = 0; j < temp[i].length; j++) {
                sum += temp[i][j];
            }
            float average = sum / temp[i].length;
            System.out.println("Average temperature of Day " + (i + 1) + ": " + average);
        }
    }

    public static void main(String[] args) {

        // Sample temperature data
        float[][] temperatures = new float[7][24];

        // Fill with sample values
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                temperatures[i][j] = 20 + (float)(Math.random() * 15);
            }
        }

        findHottestAndColdestDay(temperatures);
        System.out.println();
        averageTemperaturePerDay(temperatures);
    }
}

