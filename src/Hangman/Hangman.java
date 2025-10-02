import java.util.*;

public class Hangman {

    // Вивід заголовку
    public static void printAnnouncement() {
        System.out.println("HANGMAN");
    }

    // Вибір випадкового слова
    public static String getRandomWord() {
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    // Основна логіка гри
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String secretWord = getRandomWord();

        // приховане слово (спочатку дефіси)
        char[] hiddenWord = new char[secretWord.length()];
        Arrays.fill(hiddenWord, '-');

        // набір уже використаних букв
        Set<Character> usedLetters = new HashSet<>();

        int lives = 8; // 8 помилок дозволено

        printAnnouncement();
        System.out.println(new String(hiddenWord));

        // цикл гри
        while (lives > 0) {
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                System.out.println(new String(hiddenWord));
                continue;
            }

            char guess = input.charAt(0);

            if (!(guess >= 'a' && guess <= 'z')) {
                System.out.println("Please enter a lowercase English letter");
                System.out.println(new String(hiddenWord));
                continue;
            }

            if (usedLetters.contains(guess)) {
                System.out.println("You've already guessed this letter");
                System.out.println(new String(hiddenWord));
                continue;
            }

            usedLetters.add(guess);

            if (secretWord.indexOf(guess) >= 0) {
                // якщо буква є у слові ми її відкриваємо
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guess) {
                        hiddenWord[i] = guess;
                    }
                }
            } else {
                // Якщо букви немає
                System.out.println("That letter doesn't appear in the word");
                lives--;
            }

            System.out.println(new String(hiddenWord));

            // перевірка на перемогу
            if (new String(hiddenWord).equals(secretWord)) {
                System.out.println("You guessed the word " + secretWord + "!");
                System.out.println("You survived!");
                return;
            }
        }

        // якщо спроби закінчились
        System.out.println("You lost!");
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
