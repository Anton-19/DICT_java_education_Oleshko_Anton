package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);   // дозволяє замість коми вводити крапку в десяткових числах

        while (true) {
            // Меню
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("0. Exit");
            System.out.print("Your choice: > ");

            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    addMatrices(sc);
                    break;
                case 2:
                    multiplyByConstant(sc);
                    break;
                case 3:
                    multiplyMatrices(sc);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }

    // Додавання матриць
    public static void addMatrices(Scanner sc) {
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

        double[][] sum = new double[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                sum[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("The result is:");
        printMatrix(sum);
    }

    // Множення на константу
    public static void multiplyByConstant(Scanner sc) {
        System.out.print("Enter size of matrix: > ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[][] matrix = readMatrix(sc, n, m, "");

        System.out.print("Enter constant: > ");
        double k = sc.nextDouble();

        double[][] result = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[i][j] * k;
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    //  Множення матриць
    public static void multiplyMatrices(Scanner sc) {
        System.out.print("Enter size of first matrix: > ");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        double[][] A = readMatrix(sc, n1, m1, "first");

        System.out.print("Enter size of second matrix: > ");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        double[][] B = readMatrix(sc, n2, m2, "second");

        // Перевірка на можливість множення
        if (m1 != n2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] result = new double[n1][m2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                double sum = 0;
                for (int k = 0; k < m1; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    //  Допоміжні методи
    private static double[][] readMatrix(Scanner sc, int n, int m, String name) {
        if (!name.isEmpty()) {
            System.out.println("Enter " + name + " matrix:");
        } else {
            System.out.println("Enter matrix:");
        }
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
            for (int j = 0; j < row.length; j++) {
                // Виводимо без зайвих нулів після коми (1.0 → 1)
                if (row[j] == (int) row[j]) {
                    System.out.print((int) row[j]);
                } else {
                    System.out.print(row[j]);
                }
                if (j < row.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
