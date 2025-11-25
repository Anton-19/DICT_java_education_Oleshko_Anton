package RockPaperScissors;

import java.util.*;

public class Game {
    private final String playerName;
    private int rating;
    private final List<String> options;
    private final RatingManager ratingManager;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public Game(String playerName, int rating, List<String> options, RatingManager ratingManager) {
        this.playerName = playerName;
        this.rating = rating;
        this.options = options;
        this.ratingManager = ratingManager;
    }

    public void start() {
        System.out.println("Okay, let's start");

        while (true) {
            System.out.print("> ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("!exit")) {
                System.out.println("Bye!");
                ratingManager.updateRating(playerName, rating);
                break;
            } else if (userChoice.equals("!rating")) {
                System.out.println("Your rating: " + rating);
                continue;
            } else if (!options.contains(userChoice)) {
                System.out.println("Invalid input");
                continue;
            }

            String computerChoice = options.get(random.nextInt(options.size()));
            String result = ResultChecker.getResult(userChoice, computerChoice, options);

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
}
