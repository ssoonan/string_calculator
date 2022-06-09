package test;

import static org.junit.Assert.*;
import calculator.StringCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
    private StringCalculator strCal;

    @Before
    public void setup() {
        strCal = new StringCalculator();
    }

    @Test
    public void add_null() {
        assertEquals(0, strCal.sum(null));
        assertEquals(0, strCal.sum(""));
    }

    @Test
    public void add_single_num() {
        assertEquals(1, strCal.sum("1"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception {
        strCal.sum("-1,2,3");
    }

    @Test
    public void WholeTest() {
        int sum1 = strCal.sum("1,2");
        assertEquals(3, sum1);
        int sum2 = strCal.sum("//;;\n1;;2;;3");
        assertEquals(6, sum2);
    }
}
