package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Початкові запаси
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            System.out.print("> ");
            String action = scanner.next();

            if (action.equals("exit")) {
                break; // завершуємо програму
            }

            switch (action) {
                case "buy":
                    int[] afterBuy = buy(scanner, water, milk, beans, cups, money);
                    water = afterBuy[0];
                    milk = afterBuy[1];
                    beans = afterBuy[2];
                    cups = afterBuy[3];
                    money = afterBuy[4];
                    break;

                case "fill":
                    int[] afterFill = fill(scanner, water, milk, beans, cups, money);
                    water = afterFill[0];
                    milk = afterFill[1];
                    beans = afterFill[2];
                    cups = afterFill[3];
                    money = afterFill[4];
                    break;

                case "take":
                    money = take(money);
                    break;

                case "remaining":
                    printState(water, milk, beans, cups, money);
                    break;

                default:
                    System.out.println("Unknown action!");
            }
        }

        scanner.close();
    }

    //  Метод покупки кави
    private static int[] buy(Scanner scanner, int water, int milk, int beans, int cups, int money) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        System.out.print("> ");
        String choice = scanner.next();

        if (choice.equals("back")) {
            return new int[]{water, milk, beans, cups, money};
        }

        int waterNeed = 0;
        int milkNeed = 0;
        int beansNeed = 0;
        int price = 0;

        if (choice.equals("1")) {          // Espresso
            waterNeed = 250;
            beansNeed = 16;
            price = 4;
        } else if (choice.equals("2")) {   // Latte
            waterNeed = 350;
            milkNeed = 75;
            beansNeed = 20;
            price = 7;
        } else if (choice.equals("3")) {   // Cappuccino
            waterNeed = 200;
            milkNeed = 100;
            beansNeed = 12;
            price = 6;
        } else {
            System.out.println("Invalid coffee type.");
            return new int[]{water, milk, beans, cups, money};
        }

        // Перевірка ресурсів
        if (water < waterNeed) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkNeed) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < beansNeed) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups == 0) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeed;
            milk -= milkNeed;
            beans -= beansNeed;
            cups -= 1;
            money += price;
        }

        return new int[]{water, milk, beans, cups, money};
    }

    //  Метод поповнення запасів
    private static int[] fill(Scanner scanner, int water, int milk, int beans, int cups, int money) {
        System.out.println("Write how many ml of water do you want to add:");
        System.out.print("> ");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        System.out.print("> ");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        System.out.print("> ");
        beans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        System.out.print("> ");
        cups += scanner.nextInt();

        return new int[]{water, milk, beans, cups, money};
    }

    //  Метод видачі грошей
    private static int take(int money) {
        System.out.println("I gave you " + money);
        return 0; // гроші вилучено
    }

    //  Метод виводу стану кавомашини
    private static void printState(int water, int milk, int beans, int cups, int money) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
