
public class Amortization {

    private double amount;
    private int years;
    private int months;
    private double interest;
    private double monthlyInterest;
    private double monthlyPayment;
    private AmortSched[] schedule;
    private double totalPayment = 0;
    private double totalInterest = 0;

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getTotalPayment() { return totalPayment; }

    public double getTotalInterest() {
        return totalInterest;
    }


    public Amortization(double amount, int years, double interest) {
        this.amount = amount;
        this.years = years;
        months = years * 12;
        this.interest = interest;

        monthlyInterest = (interest / 100) / 12;
        monthlyPayment = calcMonthlyPayment(amount, monthlyInterest, years);

        schedule  = new AmortSched[months];

        CalcAmortSched();
    }


    public AmortSched[] getSchedule() {
        return schedule;
    }

    /**
     * Loop from month-0 to month-n calculating each month's interest payment, principal payment & principal balance
     */
    private void CalcAmortSched(){

        double runningBalance = amount;

        for (int i=0; i<months; i++) {
            schedule[i] = new AmortSched();

            schedule[i].month = i+1;

            schedule[i].amortization = monthlyPayment;

            schedule[i].interest = runningBalance * monthlyInterest;

            schedule[i].principal = monthlyPayment - schedule[i].interest ;

            schedule[i].balance = runningBalance - schedule[i].principal;

            runningBalance = schedule[i].balance;
            totalPayment += schedule[i].amortization;
            totalInterest += schedule[i].interest;
        }
    }



    private static double calcMonthlyPayment(double amount, double monthlyInterestRate, int numberOfYears) {
        return amount * monthlyInterestRate /
                ( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12) );
    }

}

class AmortSched {
    int month;
    double amortization;
    double interest;
    double principal;
    double balance;

    public AmortSched() {
        this.month = 0;
        this.amortization = 0;
        this.interest = 0;
        this.principal = 0;
        this.balance = 0;
    }
}
