package RockPaperScissors;

import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RatingManager ratingManager = new RatingManager("rating.txt");

        System.out.print("Enter your name: > ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        int rating = ratingManager.getRating(name);

        System.out.print("> ");
        String inputOptions = scanner.nextLine().trim();
        List<String> options;
        if (inputOptions.isEmpty()) {
            options = Arrays.asList("rock", "paper", "scissors");
        } else {
            options = Arrays.asList(inputOptions.split(","));
            options.replaceAll(String::trim);
        }

        Game game = new Game(name, rating, options, ratingManager);
        game.start();
    }
}