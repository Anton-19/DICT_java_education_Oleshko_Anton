package RockPaperScissors;

import java.io.*;
import java.util.*;

public class RockPaperScissors {

    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ім'я користувача
        System.out.print("Enter your name: > ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        System.out.print("> ");

        // Завантаження рейтингу
        int rating = loadRating(name);
        Map<String, Integer> ratings = loadAllRatings(); // Зберігаємо все, щоб потім оновити файл

        // вибір опцій
        String inputOptions = scanner.nextLine().trim();
        List<String> options;
        if (inputOptions.isEmpty()) {
            options = Arrays.asList("rock", "paper", "scissors");
        } else {
            options = Arrays.asList(inputOptions.split(","));
            options.replaceAll(String::trim);
        }

        System.out.println("Okay, let's start");

        //Ігровий цикл
        while (true) {
            System.out.print("> ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;
            } else if (userChoice.equals("!rating")) {
                System.out.println("Your rating: " + rating);
                continue;
            } else if (!options.contains(userChoice)) {
                System.out.println("Invalid input");
                continue;
            }

            // Хід комп’ютера
            String computerChoice = options.get(random.nextInt(options.size()));

            // Визначення результату
            String result = getResult(userChoice, computerChoice, options);

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

        // Оновлення рейтингу у файлі після виходу
        ratings.put(name, rating);
        saveRatings(ratings);
    }


    // Алгоритм визначення переможця
    private static String getResult(String user, String computer, List<String> options) {
        if (user.equals(computer)) return "draw";

        int userIndex = options.indexOf(user);
        List<String> reordered = new ArrayList<>();

        reordered.addAll(options.subList(userIndex + 1, options.size()));
        reordered.addAll(options.subList(0, userIndex));

        int half = reordered.size() / 2;
        List<String> beatsUser = reordered.subList(0, half); // хто б'є користувача

        if (beatsUser.contains(computer)) return "lose";
        else return "win";
    }

    // Зчитати рейтинг для конкретного користувача
    private static int loadRating(String name) {
        File file = new File("rating.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String player = scanner.next();
                int score = scanner.nextInt();
                if (player.equals(name)) return score;
            }
        } catch (FileNotFoundException ignored) {}
        return 0;
    }

    // Зчитати всі рейтинги
    private static Map<String, Integer> loadAllRatings() {
        Map<String, Integer> ratings = new HashMap<>();
        File file = new File("rating.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String player = scanner.next();
                int score = scanner.nextInt();
                ratings.put(player, score);
            }
        } catch (FileNotFoundException ignored) {}

        return ratings;
    }

    // Зберегти всі рейтинги назад у файл
    private static void saveRatings(Map<String, Integer> ratings) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("rating.txt"))) {
            for (Map.Entry<String, Integer> entry : ratings.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error saving ratings.");
        }
    }
}
