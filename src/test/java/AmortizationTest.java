import com.sirking1991.amortization.AmortSched;
import com.sirking1991.amortization.Amortization;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmortizationTest {
    int year = 10;
    double amount = 100000;
    double interest = 6.0;

    Amortization amortization = new Amortization(amount, year, interest);
    AmortSched[] schedule = amortization.getSchedule();

    @Test
    public void testScheduleArray() {
        assertTrue( schedule.getClass().isArray() );
        assertTrue( schedule.length==year*12 );
    }
    @Test
    public void testFirstMonth() {
        AmortSched first = schedule[0];
        assertTrue(round(first.interest) == 500.0 && round(first.principal) == 610.21 && round(first.balance) == 99389.79);
    }
    @Test
    public void testMidMonth() {
        // check the first element
        AmortSched mid = schedule[59];
        assertTrue(round(mid.interest) == 291.22 && round(mid.principal) == 818.98 && round(mid.balance) == 57425.98);
    }
    @Test
    public void testLastMonth() {
        // check the last element
        AmortSched last = schedule[schedule.length-1];
        assertTrue( round(last.interest)==5.52 && round(last.principal)==1104.68 && round(last.balance)==0.0 );

    }

    @Test
    public void testTotals() {
        // test monthlyPayments
        assertEquals(1110.21, round(amortization.getMonthlyPayment()), 0.0 );

        // test totalInterestPayment
        assertEquals(33224.60, round(amortization.getTotalInterest()), 0.0 );

        // test totalPayment
        assertEquals(133224.60, round(amortization.getTotalPayment()), 0.0 );
    }

    private static double round(double val) {
        val = val * 100;
        val = Math.round(val);
        return val / 100;
    }

}