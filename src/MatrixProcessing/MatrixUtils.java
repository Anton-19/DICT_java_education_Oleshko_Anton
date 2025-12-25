package MatrixProcessing;

import java.util.Scanner;

// клас для вводу та виводу матриць
public class MatrixUtils {

    // Зчитування матриці з консолі
    public static Matrix readMatrix(Scanner sc, int n, int m, String name) {
        if (!name.isEmpty()) System.out.println("Enter " + name + " matrix:");
        else System.out.println("Enter matrix:");
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            System.out.print("> ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        return new Matrix(matrix);
    }

    // Виведення матриці на екран
    public static void printMatrix(Matrix matrix) {
        double[][] data = matrix.getData();
        for (double[] row : data) {
            for (double x : row)
                System.out.print((x == (int) x ? (int) x : Math.round(x * 100.0) / 100.0) + " ");
            System.out.println();
        }
    }
}
