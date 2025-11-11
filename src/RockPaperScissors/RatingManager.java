package RockPaperScissors;

import java.io.*;
import java.util.*;

public class RatingManager {
    private final String filePath;
    private Map<String, Integer> ratings;

    public RatingManager(String filePath) {
        this.filePath = filePath;
        this.ratings = loadAllRatings();
    }

    private Map<String, Integer> loadAllRatings() {
        Map<String, Integer> map = new HashMap<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String player = scanner.next();
                int score = scanner.nextInt();
                map.put(player, score);
            }
        } catch (FileNotFoundException ignored) {}

        return map;
    }

    public int getRating(String name) {
        return ratings.getOrDefault(name, 0);
    }

    public void updateRating(String name, int newRating) {
        ratings.put(name, newRating);
        saveAll();
    }

    private void saveAll() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : ratings.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error saving ratings.");
        }
    }
}
