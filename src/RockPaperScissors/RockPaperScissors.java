package RockPaperScissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RockPaperScissors {

    private static final String[] OPTIONS = {"rock", "paper", "scissors"};
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Зчитування імені користувача
        System.out.print("Enter your name: > ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        //Завантаження рейтингу користувача
        int rating = loadRating(name);

        //Основний ігровий цикл
        while (true) {
            System.out.print("> ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;
            } else if (userChoice.equals("!rating")) {
                System.out.println("Your rating: " + rating);
                continue;
            } else if (!isValidOption(userChoice)) {
                System.out.println("Invalid input");
                continue;
            }

            // Хід комп'ютера
            String computerChoice = OPTIONS[random.nextInt(OPTIONS.length)];

            // Визначення результату
            String result = getResult(userChoice, computerChoice);

            // Виведення результату гри
            switch (result) {
                case "win":
                    System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                    rating += 100;
                    break;
                case "draw":
                    System.out.println("There is a draw (" + computerChoice + ")");
                    rating += 50;
                    break;
                case "lose":
                    System.out.println("Sorry, but the computer chose " + computerChoice);
                    break;
            }
        }
    }

    // Метод для перевірки, чи введено коректну опцію
    private static boolean isValidOption(String input) {
        for (String option : OPTIONS) {
            if (option.equals(input)) return true;
        }
        return false;
    }

    // Метод для визначення результату гри
    private static String getResult(String user, String computer) {
        if (user.equals(computer)) return "draw";

        if ((user.equals("rock") && computer.equals("scissors")) ||
                (user.equals("scissors") && computer.equals("paper")) ||
                (user.equals("paper") && computer.equals("rock"))) {
            return "win";
        }
        return "lose";
    }

    // Метод для завантаження рейтингу користувача з файлу
    private static int loadRating(String name) {
        int rating = 0;
        File file = new File("rating.txt");

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String player = fileScanner.next();
                int score = fileScanner.nextInt();
                if (player.equals(name)) {
                    rating = score;
                    break;
                }
            }
        } catch (FileNotFoundException e) {

        }

        return rating;
    }
}
