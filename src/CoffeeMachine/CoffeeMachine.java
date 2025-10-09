package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        System.out.print("> ");
        int cups = scanner.nextInt();

        // Розрахунок інгредієнтів
        int water = cups * 200; // мл води
        int milk = cups * 50;   // мл молока
        int beans = cups * 15;  // г кавових зерен

        // Вивід результатів
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");

        scanner.close();
    }
}