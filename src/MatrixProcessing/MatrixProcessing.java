package MatrixProcessing;

import java.util.Locale;
import java.util.Scanner;

// Головний клас програми, який показує меню та керує вибором користувача
public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // дозволяє вводити числа з крапкою

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
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
                case 6 -> inverseMatrix(sc);
                default -> System.out.println("Invalid choice.\n");
            }
            System.out.println();
        }
    }

    // Додавання матриць
    private static void addMatrices(Scanner sc) {
        System.out.print("Enter size of first matrix: > ");
        int n1 = sc.nextInt(), m1 = sc.nextInt();
        Matrix A = MatrixUtils.readMatrix(sc, n1, m1, "first");

        System.out.print("Enter size of second matrix: > ");
        int n2 = sc.nextInt(), m2 = sc.nextInt();
        Matrix B = MatrixUtils.readMatrix(sc, n2, m2, "second");

        if (n1 != n2 || m1 != m2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        Matrix result = A.add(B);
        System.out.println("The result is:");
        MatrixUtils.printMatrix(result);
    }

    // Множення матриці на константу
    private static void multiplyByConstant(Scanner sc) {
        System.out.print("Enter size of matrix: > ");
        int n = sc.nextInt(), m = sc.nextInt();
        Matrix matrix = MatrixUtils.readMatrix(sc, n, m, "");

        System.out.print("Enter constant: > ");
        double k = sc.nextDouble();

        Matrix result = matrix.multiplyByConstant(k);
        System.out.println("The result is:");
        MatrixUtils.printMatrix(result);
    }

    // Множення двох матриць
    private static void multiplyMatrices(Scanner sc) {
        System.out.print("Enter size of first matrix: > ");
        int n1 = sc.nextInt(), m1 = sc.nextInt();
        Matrix A = MatrixUtils.readMatrix(sc, n1, m1, "first");

        System.out.print("Enter size of second matrix: > ");
        int n2 = sc.nextInt(), m2 = sc.nextInt();
        Matrix B = MatrixUtils.readMatrix(sc, n2, m2, "second");

        if (m1 != n2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        Matrix result = A.multiply(B);
        System.out.println("The result is:");
        MatrixUtils.printMatrix(result);
    }

    // Меню транспонування
    private static void transposeMenu(Scanner sc) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: > ");
        int t = sc.nextInt();

        System.out.print("Enter matrix size: > ");
        int n = sc.nextInt(), m = sc.nextInt();
        Matrix matrix = MatrixUtils.readMatrix(sc, n, m, "");

        Matrix result;
        switch (t) {
            case 1 -> result = matrix.transposeMain();
            case 2 -> result = matrix.transposeSide();
            case 3 -> result = matrix.transposeVertical();
            case 4 -> result = matrix.transposeHorizontal();
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.println("The result is:");
        MatrixUtils.printMatrix(result);
    }

    // Обчислення визначника
    private static void calculateDeterminant(Scanner sc) {
        System.out.print("Enter matrix size: > ");
        int n = sc.nextInt(), m = sc.nextInt();

        if (n != m) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        Matrix matrix = MatrixUtils.readMatrix(sc, n, m, "");
        double det = matrix.determinant();
        System.out.println("The result is:");
        System.out.println((det == (int) det) ? (int) det : det);
    }

    // Обчислення оберненої матриці
    private static void inverseMatrix(Scanner sc) {
        System.out.print("Enter matrix size: > ");
        int n = sc.nextInt(), m = sc.nextInt();

        if (n != m) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        Matrix matrix = MatrixUtils.readMatrix(sc, n, m, "");
        double det = matrix.determinant();

        if (Math.abs(det) < 1e-9) {
            System.out.println("This matrix doesn't have an inverse.");
            return;
        }

        Matrix inverse = matrix.inverse();
        System.out.println("The result is:");
        MatrixUtils.printMatrix(inverse);
    }
}
