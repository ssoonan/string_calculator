package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
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
    public void splitTest() {
        String[] result = strCal.split("1,2");
        String[] expectedResult = {"1", "2"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void customPatternSplitTest() {
        String[] result = strCal.patternSplit("//;;\n1;;2");
        String[] expectedResult = {"1", "2"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void SumTest() {
        String[] stringArray = {"1", "2"};
        int sum = strCal.sumSplitedString(stringArray);
        assertEquals(3, sum);
    }

    @Test
    public void WholeTest() {
        int sum1 = strCal.sum("1,2");
        assertEquals(3, sum1);
        int sum2 = strCal.sum("//;;\n1;;2;;3");
        assertEquals(6, sum2);
    }
}
