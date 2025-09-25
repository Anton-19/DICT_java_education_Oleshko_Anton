import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        String botName = "my bot"; // ім’я бота
        int birthYear = 2025;

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        String yourName = scanner.nextLine();

        System.out.println("What a great name you have, " + yourName + "!");
    }
}
