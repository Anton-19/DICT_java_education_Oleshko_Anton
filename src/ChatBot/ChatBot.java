import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        String botName = "my bot"; // ім’я бота
        int birthYear = 2025;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
        System.out.print("> ");
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
        System.out.println();

        System.out.println("Now I will prove to you that I can count to any number you want!");
        System.out.print("> ");
        int num = scanner.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.println(i + "!");
        }
        System.out.println();

        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times");
        System.out.println("2. To decompose a program into small subroutines");
        System.out.println("3. To determine the execution time of a program");
        System.out.println("4. To interrupt the execution of a program");

        int answer;
        do {
            System.out.print("> ");
            answer = scanner.nextInt();
            if (answer != 2) {
                System.out.println("Please, try again.");
            }
        } while (answer != 2);

        System.out.println("Congratulations, you passed the test!");
        System.out.println("Goodbye, have a nice day!");
    }
}
