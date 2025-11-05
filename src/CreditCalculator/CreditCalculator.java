package CreditCalculator;

public class CreditCalculator {

    public static void main(String[] args) {
        // Зчитуємо параметри
        String type = System.getProperty("type");
        String principalStr = System.getProperty("principal");
        String paymentStr = System.getProperty("payment");
        String periodsStr = System.getProperty("periods");
        String interestStr = System.getProperty("interest");

        if (!checkInput(type, interestStr)) return;

        double principal = principalStr != null ? Double.parseDouble(principalStr) : 0;
        double payment = paymentStr != null ? Double.parseDouble(paymentStr) : 0;
        int months = periodsStr != null ? Integer.parseInt(periodsStr) : 0;
        double interest = Double.parseDouble(interestStr);

        if (!checkNumbers(principal, payment, months, interest)) return;

        double rate = (interest / 100) / 12; // місячна процентна ставка

        if (type.equals("diff")) {
            diffCalc(principal, months, rate, paymentStr);
        } else if (type.equals("annuity")) {
            annuityCalc(principal, payment, months, rate, principalStr, paymentStr, periodsStr);
        } else {
            System.out.println("Incorrect parameters");
        }
    }

    // Перевірки
    private static boolean checkInput(String type, String interestStr) {
        if (type == null || interestStr == null) {
            System.out.println("Incorrect parameters");
            return false;
        }
        return true;
    }

    private static boolean checkNumbers(double principal, double payment, int months, double interest) {
        if (principal < 0 || payment < 0 || months < 0 || interest < 0) {
            System.out.println("Incorrect parameters");
            return false;
        }
        return true;
    }

    // Диференційовані платежі
    private static void diffCalc(double principal, int months, double rate, String paymentStr) {
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

    // Ануїтет
    private static void annuityCalc(double principal, double payment, int months, double rate,
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

    // Знаходимо щомісячний платіж
    private static void findPayment(double principal, int months, double rate) {
        double pay = principal * (rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1);
        int rounded = (int) Math.ceil(pay);
        System.out.println("Your annuity payment = " + rounded + "!");
        int over = (int) Math.round(rounded * months - principal);
        System.out.println("Overpayment = " + over);
    }

    // Знаходимо суму кредиту
    private static void findPrincipal(double payment, int months, double rate) {
        double principal = payment / ((rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1));
        int rounded = (int) Math.floor(principal);
        System.out.println("Your loan principal = " + rounded + "!");
        int over = (int) Math.round(payment * months - rounded);
        System.out.println("Overpayment = " + over);
    }

    // Знаходимо кількість місяців
    private static void findMonths(double principal, double payment, double rate) {
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



//java "-Dtype=annuity" "-Dpayment=8722" "-Dperiods=120" "-Dinterest=5.6" CreditCalculator.CreditCalculator
//java "-Dtype=annuity" "-Dprincipal=500000" "-Dpayment=23000" "-Dinterest=7.8" CreditCalculator.CreditCalculator
// java "-Dtype=diff"  "-Dprincipal=500000"  "-Dperiods=8"  "-Dinterest=7.8" CreditCalculator.CreditCalculator
//java "-Dtype=annuity"  "-Dpayment=8722"  "-Dperiods=120"  "-Dinterest=5.6" CreditCalculator.CreditCalculator
//java "-Dtype=diff" "-Dprincipal=1000000" "-Dpayment=104000" CreditCalculator.CreditCalculator
//java "-Dtype=annuity" "-Dprincipal=1000000" "-Dperiods=60" "-Dinterest=10" CreditCalculator.CreditCalculator
