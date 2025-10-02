import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void printAnnouncement() {
        System.out.println("HANGMAN");
    }

    // Вибір випадкового слова
    public static String getRandomWord() {
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    // Головна логіка гри
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String secretWord = getRandomWord();

        // створюємо масив символів для відображення (спочатку всі дефіси)
        char[] hiddenWord = new char[secretWord.length()];
        for (int i = 0; i < secretWord.length(); i++) {
            hiddenWord[i] = '-';
        }

        int attempts = 8; // кількість спроб

        printAnnouncement();
        System.out.println(new String(hiddenWord));

        // цикл гри
        while (attempts > 0) {
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine();

            // якщо ввели більше ніж 1 символ
            if (input.length() != 1) {
                System.out.println("Please, input a single letter");
                continue;
            }

            char guess = input.charAt(0);

            boolean found = false;
            // перевіряємо, чи є буква у слові
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    hiddenWord[i] = guess; // розкриваємо букву
                    found = true;
                }
            }

            if (!found) {
                System.out.println("That letter doesn't appear in the word"); //Цієї літери немає в слові
            }

            System.out.println(new String(hiddenWord));

            attempts--; // після кожної спроби зменшуємо лічильник
        }

        System.out.println("Thanks for playing!");
        System.out.println("We'll see how well you did in the next stage");
    }

    // Основне меню
    public static void mainMenu() {
        startGame();
    }

    // Точка входу
    public static void main(String[] args) {
        mainMenu();
    }
}
