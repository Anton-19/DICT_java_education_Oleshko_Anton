package CurrencyExchange;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запитуємо код валюти
        System.out.print("Enter your currency code (example: AUD, UAH, PLN): ");
        String baseCurrency = scanner.nextLine().trim().toLowerCase();

        try {
            // Формуємо URL та робимо HTTP-запит
            String url = "http://www.floatrates.com/daily/" + baseCurrency + ".json";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Error: HTTP status " + response.statusCode());
                return;
            }

            //  Парсимо JSON
            JSONObject json = new JSONObject(response.body());

            //  Виводимо курси USD та EUR
            if (json.has("usd")) {
                JSONObject usd = json.getJSONObject("usd");
                System.out.println("USD exchange rate: " + usd.getDouble("rate"));
            } else {
                System.out.println("USD exchange rate not available for this currency.");
            }

            if (json.has("eur")) {
                JSONObject eur = json.getJSONObject("eur");
                System.out.println("EUR exchange rate: " + eur.getDouble("rate"));
            } else {
                System.out.println("EUR exchange rate not available for this currency.");
            }

        } catch (Exception e) {
            System.out.println("Error: Unable to load currency data.");
            e.printStackTrace();
        }
    }
}
