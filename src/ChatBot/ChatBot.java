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
        System.out.println();
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        System.out.print("> ");
        int rem3 = scanner.nextInt();
        System.out.print("> ");
        int rem5 = scanner.nextInt();
        System.out.print("> ");
        int rem7 = scanner.nextInt();

        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;

        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }
}
