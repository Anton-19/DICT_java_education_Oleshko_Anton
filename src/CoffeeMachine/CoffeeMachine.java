package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private String state = "chooseAction";

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public void handleInput(String input) {
        switch (state) {
            case "chooseAction" -> chooseAction(input);
            case "buy" -> processBuy(input);
            case "fillWater" -> addWater(input);
            case "fillMilk" -> addMilk(input);
            case "fillBeans" -> addBeans(input);
            case "fillCups" -> addCups(input);
        }
    }

    //  Вибір дії
    private void chooseAction(String input) {
        switch (input) {
            case "buy" -> {
                state = "buy";
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                System.out.print("> ");
            }
            case "fill" -> {
                state = "fillWater";
                System.out.println("\nWrite how many ml of water do you want to add:");
                System.out.print("> ");
            }
            case "take" -> {
                takeMoney();
                printNextAction();
            }
            case "remaining" -> {
                printState();
                printNextAction();
            }
            case "exit" -> System.exit(0);
            default -> {
                System.out.println("Unknown command");
                printNextAction();
            }
        }
    }

    //  Покупка кави
    private void processBuy(String input) {
        switch (input) {
            case "1" -> makeCoffee(250, 0, 16, 4);   // espresso
            case "2" -> makeCoffee(350, 75, 20, 7);  // latte
            case "3" -> makeCoffee(200, 100, 12, 6); // cappuccino
            case "back" -> {
                state = "chooseAction";
                printNextAction();
                return;
            }
            default -> System.out.println("Invalid choice");
        }
        state = "chooseAction";
        printNextAction();
    }

    //  Заповнення інгредієнтів
    private void addWater(String input) {
        water += Integer.parseInt(input);
        state = "fillMilk";
        System.out.println("Write how many ml of milk do you want to add:");
        System.out.print("> ");
    }

    private void addMilk(String input) {
        milk += Integer.parseInt(input);
        state = "fillBeans";
        System.out.println("Write how many grams of coffee beans do you want to add:");
        System.out.print("> ");
    }

    private void addBeans(String input) {
        beans += Integer.parseInt(input);
        state = "fillCups";
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        System.out.print("> ");
    }

    private void addCups(String input) {
        cups += Integer.parseInt(input);
        state = "chooseAction";
        printNextAction();
    }

    //  Приготування кави
    private void makeCoffee(int needWater, int needMilk, int needBeans, int cost) {
        if (!hasEnough(needWater, needMilk, needBeans)) return;

        System.out.println("I have enough resources, making you a coffee!");
        water -= needWater;
        milk -= needMilk;
        beans -= needBeans;
        cups--;
        money += cost;
    }

    private boolean hasEnough(int needWater, int needMilk, int needBeans) {
        if (water < needWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < needMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beans < needBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups <= 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }

    //  Вивід залишків
    private void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money\n");
    }

    //  Видача грошей
    private void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    // Вивід наступної дії
    private void printNextAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        System.out.print("> ");
    }

    // Головна
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();

        machine.printNextAction();

        while (true) {
            String input = scanner.nextLine().trim();
            machine.handleInput(input);
        }
    }
}
