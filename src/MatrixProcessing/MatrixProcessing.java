package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("> ");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();

        int[][] A = new int[n1][m1];

        for (int i = 0; i < n1; i++) {
            System.out.print("> ");
            for (int j = 0; j < m1; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.print("> ");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();

        int[][] B = new int[n2][m2];

        for (int i = 0; i < n2; i++) {
            System.out.print("> ");
            for (int j = 0; j < m2; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        if (n1 != n2 || m1 != m2) {
            System.out.println("ERROR");
            return;
        }

        int[][] sum = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                sum[i][j] = A[i][j] + B[i][j];
            }
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(sum[i][j]);
                if (j < m1 - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
