package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        char[][] grid = createGrid(input);

        printGrid(grid);

        makeMove(scanner, grid);

        printGrid(grid);
    }

    // Створення масиву з рядка
    private static char[][] createGrid(String input) {
        char[][] grid = new char[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = input.charAt(index++);
            }
        }
        return grid;
    }

    // Виведення сітки
    private static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Здійснення ходу користувача
    private static void makeMove(Scanner scanner, char[][] grid) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            // Перевірка чи введено 2 значення
            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row, col;

            // Перевірка на числовий формат
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            // Перевірка діапазону
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            // Перетворення координат у індекси масиву
            int x = row - 1;
            int y = col - 1;

            // Перевірка чи клітинка порожня
            if (grid[x][y] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            // Якщо все добре — ставимо “X” і виходимо з циклу
            grid[x][y] = 'X';
            break;
        }
    }
}
