// Write a program that generates five 4 digit random values and then finds their average value, and their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().

import java.util.Arrays;

public class RandomNumberStats {

    public static void main(String[] args) {

        // Generate 5 random 4-digit numbers
        int[] randomNumbers = generate4DigitRandomArray(5);

        // Display generated numbers
        System.out.println("Generated 4-digit random numbers:");
        System.out.println(Arrays.toString(randomNumbers));

        // Find average, min and max
        double[] result = findAverageMinMax(randomNumbers);

        //  results
        System.out.println("\nAverage Value: " + result[0]);
        System.out.println("Minimum Value: " + (int) result[1]);
        System.out.println("Maximum Value: " + (int) result[2]);
    }
	
	// Method to generate array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            // Generates random 4-digit number (1000 to 9999)
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }

        return numbers;
    }

    // Method to find average, minimum and maximum
    public static double[] findAverageMinMax(int[] numbers) {

        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = (double) sum / numbers.length;

        return new double[]{average, min, max};
    }
}