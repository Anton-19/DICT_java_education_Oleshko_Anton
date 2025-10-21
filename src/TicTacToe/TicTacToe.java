package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Виведення ігрового поля
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(input.charAt(i * 3 + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        // Аналіз стану гри
        char[][] grid = new char[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = input.charAt(index++);
            }
        }

        int xCount = countSymbol(grid, 'X');
        int oCount = countSymbol(grid, 'O');

        boolean xWins = checkWin(grid, 'X');
        boolean oWins = checkWin(grid, 'O');

        // Перевірка на "impossible"
        if ((xWins && oWins) || Math.abs(xCount - oCount) >= 2) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (input.contains("_")) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    // Метод для підрахунку кількості символів
    private static int countSymbol(char[][] grid, char symbol) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == symbol) {
                    count++;
                }
            }
        }
        return count;
    }

    // Метод для перевірки перемоги
    private static boolean checkWin(char[][] grid, char symbol) {
        for (int i = 0; i < 3; i++) {
            // Перевірка рядків і стовпців
            if ((grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) ||
                    (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol)) {
                return true;
            }
        }
        // Перевірка діагоналей
        if ((grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
                (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol)) {
            return true;
        }

        return false;
    }
}
