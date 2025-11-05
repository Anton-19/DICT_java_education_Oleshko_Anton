package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the loan principal:");
        System.out.print("> ");
        int principal = scanner.nextInt();

        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" – for number of monthly payments,");
        System.out.println("type \"p\" – for the monthly payment:");
        System.out.print("> ");
        String choice = scanner.next();

        if (choice.equals("m")) {
            System.out.println("Enter the monthly payment:");
            System.out.print("> ");
            int payment = scanner.nextInt();

            int months = (int) Math.ceil((double) principal / payment);

            if (months == 1) {
                System.out.println("It will take 1 month to repay the loan");
            } else {
                System.out.println("It will take " + months + " months to repay the loan");
            }

        } else if (choice.equals("p")) {
            System.out.println("Enter the number of months:");
            System.out.print("> ");
            int months = scanner.nextInt();

            double payment = (double) principal / months;
            int roundedPayment = (int) Math.ceil(payment);
            int lastPayment = principal - (months - 1) * roundedPayment;

            if (lastPayment == roundedPayment) {
                System.out.println("Your monthly payment = " + roundedPayment);
            } else {
                System.out.println("Your monthly payment = " + roundedPayment +
                        " and the last payment = " + lastPayment + ".");
            }
        } else {
            System.out.println("Invalid option!");
        }

        scanner.close();
    }
}
