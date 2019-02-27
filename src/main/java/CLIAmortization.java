import java.text.DecimalFormat;
import java.util.Scanner;

public class CLIAmortization {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Loan Amortization Calculator");

        System.out.println("Loan amount (without comma): ");
        double amount = scnr.nextDouble();

        System.out.println("Payment tearms (in years): ");
        int years = scnr.nextInt();

        System.out.println("Interest rate (in Percent): ");
        double interest = scnr.nextDouble();


        Amortization amortization = new Amortization(amount, years, interest);

        AmortSched[] schedule = amortization.getSchedule();

        System.out.println("Monthly payment:"+amortization.getMonthlyPayment()+" Total interest:"+amortization.getTotalInterest()+" Total payment:"+amortization.getTotalPayment());

        System.out.println(" #  /  Payment  /  Interest  /  Principal  /  Balance");

        for (int i = 0; i < schedule.length; i++) {
            System.out.println(schedule[i].month + "  /  " +
                    round(schedule[i].amortization) + "  /  " +
                    round(schedule[i].interest) + "  /  " +
                    round(schedule[i].principal) + "  /  " +
                    round(schedule[i].balance)
            );
        }

    }

    private static double round(double val) {
        val = val * 100;
        val = Math.round(val);
        return val / 100;
    }
}