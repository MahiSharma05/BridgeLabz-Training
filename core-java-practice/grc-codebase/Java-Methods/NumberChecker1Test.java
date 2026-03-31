import java.util.Arrays;

// Utility class (no public modifier)
class NumberChecker1 {

    public static int countDigits(int number) {
        int count = 0;
        int n = number;
        if (n == 0) return 1;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int n = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int[] digits) {
        int n = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, n);
        }
        int number = 0;
        for (int d : digits) {
            number = number * 10 + d;
        }
        return sum == number;
    }

    public static int[] largestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] smallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }
}

// Test class (public, matches file name)
public class NumberChecker1Test {
    public static void main(String[] args) {
        int number = 153; 
        System.out.println("Number: " + number);

        int digitCount = NumberChecker1.countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        int[] digits = NumberChecker1.getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        boolean isDuck = NumberChecker1.isDuckNumber(digits);
        System.out.println("Is Duck number? " + isDuck);

        boolean isArmstrong = NumberChecker1.isArmstrongNumber(digits);
        System.out.println("Is Armstrong number? " + isArmstrong);

        int[] largest = NumberChecker1.largestAndSecondLargest(digits);
        System.out.println("Largest: " + largest[0] + ", Second Largest: " + largest[1]);

        int[] smallest = NumberChecker1.smallestAndSecondSmallest(digits);
        System.out.println("Smallest: " + smallest[0] + ", Second Smallest: " + smallest[1]);
    }
}

