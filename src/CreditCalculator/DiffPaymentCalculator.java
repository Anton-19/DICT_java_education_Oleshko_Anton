package CreditCalculator;

public class DiffPaymentCalculator {

    public void calculate(double principal, int months, double rate, String paymentStr) {
        if (principal == 0 || months == 0 || paymentStr != null) {
            System.out.println("Incorrect parameters");
            return;
        }

        double total = 0;
        for (int m = 1; m <= months; m++) {
            double pay = (principal / months) + rate * (principal - (principal * (m - 1) / months));
            int rounded = (int) Math.ceil(pay);
            total += rounded;
            System.out.println("Month " + m + ": payment is " + rounded);
        }

        int over = (int) Math.round(total - principal);
        System.out.println("Overpayment = " + over);
    }
}
