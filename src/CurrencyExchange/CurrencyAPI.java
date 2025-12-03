package CurrencyExchange;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class CurrencyAPI {

    public static Map<String, Double> fetchRates(String baseCurrency) {
        Map<String, Double> ratesMap = new HashMap<>();
        try {
            String url = "http://www.floatrates.com/daily/" + baseCurrency.toLowerCase() + ".json";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject json = new JSONObject(response.body());
                for (String key : json.keySet()) {
                    JSONObject currency = json.getJSONObject(key);
                    ratesMap.put(key.toLowerCase(), currency.getDouble("rate"));
                }
            } else {
                System.out.println("Error fetching rates. HTTP status: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error fetching rates: " + e.getMessage());
        }
        return ratesMap;
    }
}
