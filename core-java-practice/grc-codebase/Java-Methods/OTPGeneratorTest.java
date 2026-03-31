// Write a program to generate a six-digit OTP number using Math.random() method. Validate the numbers are unique by generating the OTP number 10 times and ensuring all the 10 OTPs are not the same

import java.util.Arrays;

class OTPGenerator {

    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        // Generates a number between 100000 and 999999
        return 100000 + (int)(Math.random() * 900000);
    }

    // Method to check if all OTPs in the array are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) return false;
            }
        }
        return true;
    }
}

// Test class
public class OTPGeneratorTest {
    public static void main(String[] args) {
        int[] otpArray = new int[10]; // Array to store 10 OTPs

        // Generate 10 OTPs
        for (int i = 0; i < 10; i++) {
            otpArray[i] = OTPGenerator.generateOTP();
        }

        // Display the generated OTPs
        System.out.println("Generated OTPs: " + Arrays.toString(otpArray));

        // Validate uniqueness
        boolean unique = OTPGenerator.areOTPsUnique(otpArray);
        System.out.println("Are all OTPs unique? " + unique);
    }
}
