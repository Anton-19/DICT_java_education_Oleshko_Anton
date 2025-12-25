package CreditCalculator;

public class AnnuityCalculator {

    public void calculate(double principal, double payment, int months, double rate,
                          String principalStr, String paymentStr, String periodsStr) {

        if (principalStr != null && paymentStr != null && periodsStr != null) {
            System.out.println("Incorrect parameters");
            return;
        }

        if (paymentStr == null) {
            findPayment(principal, months, rate);
        } else if (principalStr == null) {
            findPrincipal(payment, months, rate);
        } else if (periodsStr == null) {
            findMonths(principal, payment, rate);
        } else {
            System.out.println("Incorrect parameters");
        }
    }

    private void findPayment(double principal, int months, double rate) {
        double pay = principal * (rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1);
        int rounded = (int) Math.ceil(pay);
        System.out.println("Your annuity payment = " + rounded + "!");
        int over = (int) Math.round(rounded * months - principal);
        System.out.println("Overpayment = " + over);
    }

    private void findPrincipal(double payment, int months, double rate) {
        double principal = payment / ((rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1));
        int rounded = (int) Math.floor(principal);
        System.out.println("Your loan principal = " + rounded + "!");
        int over = (int) Math.round(payment * months - rounded);
        System.out.println("Overpayment = " + over);
    }

    private void findMonths(double principal, double payment, double rate) {
        double n = Math.log(payment / (payment - rate * principal)) / Math.log(1 + rate);
        int months = (int) Math.ceil(n);
        int years = months / 12;
        int remain = months % 12;

        String text = "It will take ";
        if (years > 0) text += years + (years == 1 ? " year" : " years");
        if (years > 0 && remain > 0) text += " and ";
        if (remain > 0) text += remain + (remain == 1 ? " month" : " months");
        text += " to repay this loan!";

        System.out.println(text);
        int over = (int) Math.round(payment * months - principal);
        System.out.println("Overpayment = " + over);
    }
}
