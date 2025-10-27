package MatrixProcessing;

import java.util.Locale;
import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // дозволяє вводити десяткові числа з крапкою

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("0. Exit");
            System.out.print("Your choice: > ");

            int choice = sc.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1 -> addMatrices(sc);
                case 2 -> multiplyByConstant(sc);
                case 3 -> multiplyMatrices(sc);
                case 4 -> transposeMenu(sc);
                case 5 -> calculateDeterminant(sc);
                default -> System.out.println("Invalid choice.\n");
            }
            System.out.println();
        }
    }

    //  Додавання
    private static void addMatrices(Scanner sc) {
        System.out.print("Enter size of first matrix: > ");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        double[][] A = readMatrix(sc, n1, m1, "first");

        System.out.print("Enter size of second matrix: > ");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        double[][] B = readMatrix(sc, n2, m2, "second");

        if (n1 != n2 || m1 != m2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] result = new double[n1][m1];
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < m1; j++)
                result[i][j] = A[i][j] + B[i][j];

        System.out.println("The result is:");
        printMatrix(result);
    }

    // Множення на константу
    private static void multiplyByConstant(Scanner sc) {
        System.out.print("Enter size of matrix: > ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[][] matrix = readMatrix(sc, n, m, "");

        System.out.print("Enter constant: > ");
        double k = sc.nextDouble();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] *= k;

        System.out.println("The result is:");
        printMatrix(matrix);
    }

    //  Множення матриць
    private static void multiplyMatrices(Scanner sc) {
        System.out.print("Enter size of first matrix: > ");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        double[][] A = readMatrix(sc, n1, m1, "first");

        System.out.print("Enter size of second matrix: > ");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        double[][] B = readMatrix(sc, n2, m2, "second");

        if (m1 != n2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] result = new double[n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    //  Транспонування
    private static void transposeMenu(Scanner sc) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: > ");
        int t = sc.nextInt();

        System.out.print("Enter matrix size: > ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[][] matrix = readMatrix(sc, n, m, "");

        double[][] result;
        switch (t) {
            case 1 -> result = transposeMain(matrix);
            case 2 -> result = transposeSide(matrix);
            case 3 -> result = transposeVertical(matrix);
            case 4 -> result = transposeHorizontal(matrix);
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    //  Визначник
    private static void calculateDeterminant(Scanner sc) {
        System.out.print("Enter matrix size: > ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n != m) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] matrix = readMatrix(sc, n, m, "");
        double det = determinant(matrix);
        System.out.println("The result is:");
        System.out.println((det == (int) det) ? (int) det : det);
    }

    //  Допоміжні функції
    private static double[][] readMatrix(Scanner sc, int n, int m, String name) {
        if (!name.isEmpty()) System.out.println("Enter " + name + " matrix:");
        else System.out.println("Enter matrix:");
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            System.out.print("> ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double x : row)
                System.out.print((x == (int) x ? (int) x : x) + " ");
            System.out.println();
        }
    }

    //  Транспонування
    private static double[][] transposeMain(double[][] a) {
        int n = a.length, m = a[0].length;
        double[][] t = new double[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[j][i] = a[i][j];
        return t;
    }

    private static double[][] transposeSide(double[][] a) {
        int n = a.length, m = a[0].length;
        double[][] t = new double[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[m - 1 - j][n - 1 - i] = a[i][j];
        return t;
    }

    private static double[][] transposeVertical(double[][] a) {
        int n = a.length, m = a[0].length;
        double[][] t = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[i][m - 1 - j] = a[i][j];
        return t;
    }

    private static double[][] transposeHorizontal(double[][] a) {
        int n = a.length, m = a[0].length;
        double[][] t = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[n - 1 - i][j] = a[i][j];
        return t;
    }

    //  Обчислення визначника
    private static double determinant(double[][] a) {
        int n = a.length;
        if (n == 1) return a[0][0];
        if (n == 2) return a[0][0] * a[1][1] - a[0][1] * a[1][0];

        double det = 0;
        for (int k = 0; k < n; k++) {
            double[][] minor = new double[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                int colIndex = 0;
                for (int j = 0; j < n; j++) {
                    if (j == k) continue;
                    minor[i - 1][colIndex++] = a[i][j];
                }
            }
            det += a[0][k] * Math.pow(-1, k) * determinant(minor);
        }
        return det;
    }
}
