package CreditCalculator;

public class CreditCalculator {
    public static void main(String[] args) {
        // Отримуємо параметри з командного рядка
        String type = System.getProperty("type");
        String principalStr = System.getProperty("principal");
        String paymentStr = System.getProperty("payment");
        String periodsStr = System.getProperty("periods");
        String interestStr = System.getProperty("interest");

        // Перевіряємо введення
        if (!InputValidator.checkInput(type, interestStr)) return;

        double principal = principalStr != null ? Double.parseDouble(principalStr) : 0;
        double payment = paymentStr != null ? Double.parseDouble(paymentStr) : 0;
        int months = periodsStr != null ? Integer.parseInt(periodsStr) : 0;
        double interest = Double.parseDouble(interestStr);

        if (!InputValidator.checkNumbers(principal, payment, months, interest)) return;

        double rate = (interest / 100) / 12; // місячна процентна ставка

        if (type.equals("diff")) {
            new DiffPaymentCalculator().calculate(principal, months, rate, paymentStr);
        } else if (type.equals("annuity")) {
            new AnnuityCalculator().calculate(principal, payment, months, rate, principalStr, paymentStr, periodsStr);
        } else {
            System.out.println("Incorrect parameters");
        }
    }
}

// Приклади
//cd C:\Users\Asus\IdeaProjects\Khai_DICT\src
//javac CreditCalculator\*.java
//java "-Dtype=annuity" "-Dpayment=8722" "-Dperiods=120" "-Dinterest=5.6" CreditCalculator.CreditCalculator
//java "-Dtype=annuity" "-Dprincipal=500000" "-Dpayment=23000" "-Dinterest=7.8" CreditCalculator.CreditCalculator
// java "-Dtype=diff"  "-Dprincipal=500000"  "-Dperiods=8"  "-Dinterest=7.8" CreditCalculator.CreditCalculator
//java "-Dtype=annuity"  "-Dpayment=8722"  "-Dperiods=120"  "-Dinterest=5.6" CreditCalculator.CreditCalculator
//java "-Dtype=diff" "-Dprincipal=1000000" "-Dpayment=104000" CreditCalculator.CreditCalculator
//java "-Dtype=annuity" "-Dprincipal=1000000" "-Dperiods=60" "-Dinterest=10" CreditCalculator.CreditCalculator
//java "-Dprincipal=1000000" "-Dperiods=60" "-Dinterest=10" CreditCalculator.CreditCalculator

