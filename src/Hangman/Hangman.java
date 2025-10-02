import java.util.Random;
import java.util.Scanner;

public class Hangman {

    // Функція для виводу вітального повідомлення
    public static void printAnnouncement() {
        System.out.println("HANGMAN");
    }

    // Функція для початку гри
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);

        // список можливих слів
        String[] words = {"python", "java", "javascript", "kotlin"};

        // вибираємо випадкове слово
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        System.out.print("Guess the word: > ");
        String guess = scanner.nextLine();

        if (guess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }

    // Основне меню
    public static void mainMenu() {
        printAnnouncement();
        startGame();
    }

    // Головна функція (точка входу)
    public static void main(String[] args) {
        mainMenu();
    }
}
