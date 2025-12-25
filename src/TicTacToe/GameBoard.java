package TicTacToe;

// Клас, що зберігає та керує ігровим полем
public class GameBoard {
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        clear();
    }

    // Заповнити поле пробілами
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Вивести поле
    public void print() {
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

    // Перевірка клітинка порожня чи ні
    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    //  Записати хід
    public void setCell(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Отримати клітинку
    public char getCell(int row, int col) {
        return board[row][col];
    }

    // Перевірка на нічию
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Перевірка на перемогу певного гравця
    public boolean checkWin(char symbol) {
        return checkRows(symbol) || checkCols(symbol) || checkDiagonals(symbol);
    }

    private boolean checkRows(char s) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == s && board[i][1] == s && board[i][2] == s)
                return true;
        }
        return false;
    }

    private boolean checkCols(char s) {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == s && board[1][j] == s && board[2][j] == s)
                return true;
        }
        return false;
    }

    private boolean checkDiagonals(char s) {
        return (board[0][0] == s && board[1][1] == s && board[2][2] == s) ||
                (board[0][2] == s && board[1][1] == s && board[2][0] == s);
    }
}
