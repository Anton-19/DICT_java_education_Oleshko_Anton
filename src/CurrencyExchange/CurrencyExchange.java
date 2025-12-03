package CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base currency code: ");
        String baseCurrency = scanner.nextLine().trim();

        ICurrencyConverter converter = new CurrencyConverter(baseCurrency);

        while (true) {
            System.out.print("Enter target currency code (or empty to exit): ");
            String targetCurrency = scanner.nextLine().trim();
            if (targetCurrency.isEmpty()) break;

            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            double exchanged = converter.convert(targetCurrency, amount);
            System.out.printf("You received %.2f %s.%n", exchanged, targetCurrency.toUpperCase());
        }

        System.out.println("Program finished.");
    }
}
