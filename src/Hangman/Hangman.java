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
                // якщо буква є у слові — розкриваємо
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

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        printAnnouncement();

        while (true) {
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: > ");
            String choice = scanner.nextLine();

            if (choice.equals("play")) {
                startGame();
            } else if (choice.equals("exit")) {
                break;
            } else {
                continue;            // якщо некоректне введення — цикл повторюється
            }
        }
    }

    // Точка входу
    public static void main(String[] args) {
        mainMenu();
    }
}
