package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        System.out.print("> ");
        String choice = scanner.next();

        switch (choice) {
            case "n":
                System.out.println("Enter the loan principal:");
                System.out.print("> ");
                double principal = scanner.nextDouble();

                System.out.println("Enter the monthly payment:");
                System.out.print("> ");
                double payment = scanner.nextDouble();

                System.out.println("Enter the loan interest:");
                System.out.print("> ");
                double interest = scanner.nextDouble();

                double i = (interest / 100) / 12;
                double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
                int months = (int) Math.ceil(n);

                int years = months / 12;
                int remainingMonths = months % 12;

                String result = "It will take ";
                if (years > 0) result += years + (years == 1 ? " year" : " years");
                if (years > 0 && remainingMonths > 0) result += " and ";
                if (remainingMonths > 0) result += remainingMonths + (remainingMonths == 1 ? " month" : " months");
                result += " to repay this loan!";

                System.out.println(result);
                break;

            case "a":
                System.out.println("Enter the loan principal:");
                System.out.print("> ");
                principal = scanner.nextDouble();

                System.out.println("Enter the number of periods:");
                System.out.print("> ");
                int periods = scanner.nextInt();

                System.out.println("Enter the loan interest:");
                System.out.print("> ");
                interest = scanner.nextDouble();

                i = (interest / 100) / 12;
                double annuity = principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);
                System.out.println("Your monthly payment = " + Math.ceil(annuity) + "!");
                break;

            case "p":
                System.out.println("Enter the annuity payment:");
                System.out.print("> ");
                annuity = scanner.nextDouble();

                System.out.println("Enter the number of periods:");
                System.out.print("> ");
                periods = scanner.nextInt();

                System.out.println("Enter the loan interest:");
                System.out.print("> ");
                interest = scanner.nextDouble();

                i = (interest / 100) / 12;
                principal = annuity / ((i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1));
                System.out.println("Your loan principal = " + Math.floor(principal) + "!");
                break;

            default:
                System.out.println("Invalid option!");
        }

        scanner.close();
    }
}
