package TicTacToe;

import java.util.Scanner;

// Клас, що відповідає за хід гравця
public class Player {
    private char symbol;
    private Scanner scanner;

    public Player(char symbol, Scanner scanner) {
        this.symbol = symbol;
        this.scanner = scanner;
    }

    public char getSymbol() {
        return symbol;
    }

    // Отримання коректних координат
    public int[] getMove(GameBoard board) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length != 2) {
                System.out.println("You should enter two numbers!");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (!board.isCellEmpty(row - 1, col - 1)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            return new int[]{row - 1, col - 1};
        }
    }
}
