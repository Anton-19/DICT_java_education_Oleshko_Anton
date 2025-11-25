package RockPaperScissors;

import java.util.*;

public class ResultChecker {
    public static String getResult(String user, String computer, List<String> options) {
        if (user.equals(computer)) return "draw";

        int userIndex = options.indexOf(user);
        List<String> reordered = new ArrayList<>();
        reordered.addAll(options.subList(userIndex + 1, options.size()));
        reordered.addAll(options.subList(0, userIndex));

        int half = reordered.size() / 2;
        List<String> beatsUser = reordered.subList(0, half);

        if (beatsUser.contains(computer)) return "lose";
        else return "win";
    }
}
