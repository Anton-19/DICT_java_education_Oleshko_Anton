package TicTacToe;

import java.util.Scanner;

// Основний клас гри
public class TicTacToe {
    private GameBoard board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public TicTacToe() {
        board = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        playerX = new Player('X', scanner);
        playerO = new Player('O', scanner);
        currentPlayer = playerX;
    }

    public void play() {
        board.print();

        while (true) {
            int[] move = currentPlayer.getMove(board);
            board.setCell(move[0], move[1], currentPlayer.getSymbol());
            board.print();

            if (board.checkWin(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getSymbol() + " wins");
                break;
            } else if (board.isDraw()) {
                System.out.println("Draw");
                break;
            }

            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
