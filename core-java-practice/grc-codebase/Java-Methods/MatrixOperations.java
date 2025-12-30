// Write a program to perform matrix manipulation operations like addition, subtraction, and multiplication. The program should take random matrices as input and display the result of the operations

import java.util.Scanner;

public class MatrixOperations {

    // Method to create a random matrix
    public static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 10); // 0 to 9
            }
        }
        return matrix;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int common = B.length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter rows of Matrix A: ");
        int r1 = input.nextInt();
        System.out.print("Enter columns of Matrix A: ");
        int c1 = input.nextInt();

        System.out.print("Enter rows of Matrix B: ");
        int r2 = input.nextInt();
        System.out.print("Enter columns of Matrix B: ");
        int c2 = input.nextInt();

        int[][] A = createMatrix(r1, c1);
        int[][] B = createMatrix(r2, c2);

        System.out.println("\nMatrix A:");
        displayMatrix(A);

        System.out.println("\nMatrix B:");
        displayMatrix(B);

        // Addition & Subtraction (only if same size)
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nA + B:");
            displayMatrix(addMatrices(A, B));

            System.out.println("\nA - B:");
            displayMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("\nAddition & Subtraction not possible (different dimensions)");
        }

        // Multiplication
        if (c1 == r2) {
            System.out.println("\nA × B:");
            displayMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMatrix multiplication not possible");
        }

        input.close();
    }
}
