import java.util.Random;
import java.util.Scanner;

public class Hangman {

    // Функція для виводу вітального повідомлення
    public static void printAnnouncement() {
        System.out.println("HANGMAN");
    }

    // Функція для створення підказки
    public static String makeHint(String word) {
        // беремо перші дві букви
        String hint = word.substring(0, 2);

        // решту замінюємо на дефіси
        for (int i = 2; i < word.length(); i++) {
            hint += "-";
        }

        return hint;
    }

    // Функція для початку гри
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);

        // список можливих слів
        String[] words = {"python", "java", "javascript", "kotlin"};

        // вибираємо випадкове слово
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        // створюємо підказку
        String hint = makeHint(secretWord);

        System.out.print("Guess the word " + hint + ": > ");
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

    // Головна функція
    public static void main(String[] args) {
        mainMenu();
    }
}
