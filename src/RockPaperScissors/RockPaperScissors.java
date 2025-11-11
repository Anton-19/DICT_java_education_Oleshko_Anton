package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"rock", "paper", "scissors"};

        while (true) {
            System.out.print("> ");
            String userChoice = scanner.nextLine().toLowerCase();

            // Перевіряємо, чи користувач хоче вийти
            if (userChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }

            // Перевіряємо правильність введення
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid input");
                continue;
            }

            // Випадковий вибір комп'ютера
            String computerChoice = options[random.nextInt(3)];

            // Визначення результату
            if (userChoice.equals(computerChoice)) {
                System.out.println("There is a draw (" + computerChoice + ")");
            } else if (
                    (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                            (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                            (userChoice.equals("paper") && computerChoice.equals("rock"))
            ) {
                System.out.println("Well done. The computer chose " + computerChoice + " and failed");
            } else {
                System.out.println("Sorry, but the computer chose " + computerChoice);
            }
        }
    }
}
