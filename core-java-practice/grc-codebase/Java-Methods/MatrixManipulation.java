// Write a program to perform matrix manipulation operations like finding the transpose, determinant, and inverse of a matrix. The program should take random matrices as input and display the result of the operations.

import java.util.Scanner;

public class MatrixManipulation {

    // Method to create random matrix
    public static double[][] createMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 10); // 0–9
            }
        }
        return matrix;
    }

    // Method to find transpose
    public static double[][] transpose(double[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        double[][] t = new double[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                t[j][i] = matrix[i][j];
            }
        }
        return t;
    }

    // Method to find determinant (2x2 or 3x3 only)
    public static double determinant(double[][] m) {
        if (m.length == 2) {
            return m[0][0] * m[1][1] - m[0][1] * m[1][0];
        } else {
            return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                 - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                 + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
        }
    }

    // Method to find inverse (2x2 matrix)
    public static double[][] inverse(double[][] m) {
        double det = determinant(m);

        if (det == 0) {
            return null;
        }

        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] = m[0][0] / det;

        return inv;
    }

    // Method to display matrix
    public static void display(double[][] m) {
        for (double[] row : m) {
            for (double val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int cols = input.nextInt();

        double[][] matrix = createMatrix(rows, cols);

        System.out.println("\nMatrix:");
        display(matrix);

        System.out.println("\nTranspose:");
        display(transpose(matrix));

        // Determinant & inverse only for square matrices
        if (rows == cols && (rows == 2 || rows == 3)) {

            double det = determinant(matrix);
            System.out.println("\nDeterminant = " + det);

            if (rows == 2) {
                double[][] inv = inverse(matrix);
                if (inv != null) {
                    System.out.println("\nInverse:");
                    display(inv);
                } else {
                    System.out.println("\nInverse not possible (determinant = 0)");
                }
            }
        } else {
            System.out.println("\nDeterminant & Inverse not possible");
        }

        input.close();
    }
}
