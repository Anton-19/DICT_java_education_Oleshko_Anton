package CoffeeMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();

        // показуємо початкову підказку
        machine.printNextAction();

        // нескінченний цикл читання команд користувача
        while (true) {
            String input = scanner.nextLine().trim();
            machine.handleInput(input);
        }
    }
}
