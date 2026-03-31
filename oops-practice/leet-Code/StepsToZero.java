// LeetCode 1342 – Number of Steps to Reduce a Number to Zero

package leetCode;

public class StepsToZero {

	public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
	}
	public static int numberOfSteps(int num) {
        int steps = 0;

        while (num != 0) {
            if (num % 2 == 0)
                num /= 2;
            else
                num -= 1;
            steps++;
        }
        return steps;
    }
}
