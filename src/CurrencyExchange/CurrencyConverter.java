package CurrencyExchange;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter implements ICurrencyConverter {

    private String baseCurrency;
    private Map<String, Map<String, Double>> cache = new HashMap<>();

    public CurrencyConverter(String baseCurrency) {
        this.baseCurrency = baseCurrency.toLowerCase();
    }

    @Override
    public double convert(String targetCurrency, double amount) {
        targetCurrency = targetCurrency.toLowerCase();
        System.out.println("Checking the cache...");

        if (!cache.containsKey(baseCurrency)) {
            System.out.println("Sorry, but it is not in the cache!");
            cache.put(baseCurrency, CurrencyAPI.fetchRates(baseCurrency));
        } else {
            System.out.println("It is in the cache!");
        }

        Map<String, Double> rates = cache.get(baseCurrency);

        if (!rates.containsKey(targetCurrency)) {
            System.out.println("Rate for target currency not available.");
            return 0;
        }

        double rate = rates.get(targetCurrency);
        double result = amount * rate;

        // Округлення до 2 знаків
        result = Math.round(result * 100.0) / 100.0;

        return result;
    }
}
