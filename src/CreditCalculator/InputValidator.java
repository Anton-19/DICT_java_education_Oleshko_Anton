package CreditCalculator;

public class InputValidator {

    public static boolean checkInput(String type, String interestStr) {
        if (type == null || interestStr == null) {
            System.out.println("Incorrect parameters");
            return false;
        }
        return true;
    }

    public static boolean checkNumbers(double principal, double payment, int months, double interest) {
        if (principal < 0 || payment < 0 || months < 0 || interest < 0) {
            System.out.println("Incorrect parameters");
            return false;
        }
        return true;
    }
}
