public class Hangman {

    // Функція для виводу вітального повідомлення
    public static void printAnnouncement() {
        System.out.println("     HANGMAN GAME      ");
        System.out.println("The game will be available soon.");
    }

    public static void mainMenu() {
        printAnnouncement();
    }

    public static void main(String[] args) {
        mainMenu();
    }
}