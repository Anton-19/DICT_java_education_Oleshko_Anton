package TicTacToe;

import java.util.Scanner;

// Клас гри "Хрестики-нулики"
public class TicTacToe {
    private char[][] board;         // Ігрове поле
    private char currentPlayer;
    private Scanner scanner;        // Сканер для вводу

    // створює порожнє поле та задає початкового гравця
    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
        scanner = new Scanner(System.in);
    }

    // Основний метод для запуску гри
    public void play() {
        printBoard();

        while (true) {
            makeMove();

            printBoard();

            if (checkWin()) {
                System.out.println(currentPlayer + " wins");
                break;
            } else if (isDraw()) {
                System.out.println("Draw");
                break;
            }

            switchPlayer();
        }

        scanner.close();
    }

    // Метод для одного ходу гравця
    private void makeMove() {
        int[] coords = getValidCoordinates();
        int row = coords[0];
        int col = coords[1];
        board[row][col] = currentPlayer;
    }

    // Отримання і перевірка правильності координат
    private int[] getValidCoordinates() {
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

            if (!isInRange(row, col)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (!isCellEmpty(row - 1, col - 1)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            return new int[]{row - 1, col - 1};
        }
    }

    // Перевірка, чи координати в межах поля
    private boolean isInRange(int row, int col) {
        return row >= 1 && row <= 3 && col >= 1 && col <= 3;
    }

    // Перевірка, чи комірка порожня
    private boolean isCellEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    // виведення ігрового поля
    private void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    //  Перевірка перемоги
    private boolean checkWin() {
        return checkRows() || checkCols() || checkDiagonals();
    }

    //  Перевірка рядків
    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                    board[i][1] == currentPlayer &&
                    board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Перевірка стовпців
    private boolean checkCols() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer &&
                    board[1][j] == currentPlayer &&
                    board[2][j] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    //  Перевірка діагоналей
    private boolean checkDiagonals() {
        return (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer &&
                        board[1][1] == currentPlayer &&
                        board[2][0] == currentPlayer);
    }

    //  Перевірка на нічию
    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    //  Перемикання гравців
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Точка входу
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
