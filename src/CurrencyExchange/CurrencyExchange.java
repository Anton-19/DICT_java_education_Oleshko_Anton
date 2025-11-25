package CurrencyExchange;

import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо кількість mycoins
        System.out.print("> ");
        double mycoins = scanner.nextDouble();

        double rateARS = 0.82;      // аргентинське песо
        double rateHNL = 0.17;      // гондураська лемпіра
        double rateAUD = 1.9622;    // австралійський долар
        double rateMAD = 0.208;     // марокканський дирхам

        // Обчислюємо значення
        double ars = mycoins * rateARS;
        double hnl = mycoins * rateHNL;
        double aud = mycoins * rateAUD;
        double mad = mycoins * rateMAD;

        // Виводимо результат з округленням до 2 знаків
        System.out.println(String.format("I will get %.2f ARS from the sale of %.1f mycoins.", ars, mycoins));
        System.out.println(String.format("I will get %.2f HNL from the sale of %.1f mycoins.", hnl, mycoins));
        System.out.println(String.format("I will get %.2f AUD from the sale of %.1f mycoins.", aud, mycoins));
        System.out.println(String.format("I will get %.2f MAD from the sale of %.1f mycoins.", mad, mycoins));
    }
}
