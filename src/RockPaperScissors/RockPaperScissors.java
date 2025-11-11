package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"rock", "paper", "scissors"};

        System.out.print("> ");
        String userChoice = scanner.nextLine().toLowerCase();

        if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
            System.out.println("Invalid input. Please enter rock, paper, or scissors.");
            return;
        }

        String computerChoice = options[random.nextInt(3)];

        String result;
        if (userChoice.equals(computerChoice)) {
            result = "draw";
        } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                        (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                        (userChoice.equals("paper") && computerChoice.equals("rock"))
        ) {
            result = "win";
        } else {
            result = "lose";
        }

        switch (result) {
            case "win":
                System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                break;
            case "draw":
                System.out.println("There is a draw (" + computerChoice + ")");
                break;
            case "lose":
                System.out.println("Sorry, but the computer chose " + computerChoice);
                break;
        }
    }
}
