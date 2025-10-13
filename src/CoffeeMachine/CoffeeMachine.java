package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення даних
        int water = Ingredient(scanner, "water");
        int milk = Ingredient(scanner, "milk");
        int beans = Ingredient(scanner, "coffee beans");
        int cupsNeeded = Cups(scanner);

        // Розрахунок і вивід результату
        printResult(water, milk, beans, cupsNeeded);

        scanner.close();
    }

    //   запит інгредієнтів
    private static int Ingredient(Scanner scanner, String ingredient) {
        System.out.println("Write how many ml of " + ingredient + " the coffee machine has:");
        System.out.print("> ");
        return scanner.nextInt();
    }

    //  запит кількості чашок
    private static int Cups(Scanner scanner) {
        System.out.println("\nWrite how many cups of coffee you will need:");
        System.out.print("> ");
        return scanner.nextInt();
    }

    //  розрахунок скільки чашок можна приготувати
    private static int calculateCups(int water, int milk, int beans) {
        int waterPerCup = 200;
        int milkPerCup = 50;
        int beansPerCup = 15;
        return Math.min(
                Math.min(water / waterPerCup, milk / milkPerCup),
                beans / beansPerCup
        );
    }

    //  вивод результату
    private static void printResult(int water, int milk, int beans, int cupsNeeded) {
        int possibleCups = calculateCups(water, milk, beans);

        if (cupsNeeded == possibleCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsNeeded < possibleCups) {
            int extra = possibleCups - cupsNeeded;
            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCups + " cups of coffee");
        }
    }
}
