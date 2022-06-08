package test;

import static org.junit.Assert.assertEquals;

import calculator.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    // main문으로 할 필요됴 없음
    private Calculator cal; // 미리 선언해 before로 매번 대임

    @Before
    public void setup() {
        cal = new Calculator();
    }

    @Test
    public void add () {
        assertEquals(9, cal.add(3, 6));
        System.out.println("add");
    }
    @Test
    public void subtract () {
        assertEquals(-3, cal.subtract(3, 6));
        System.out.println("subtract");
    }
    @After
    public void teardown() {
        System.out.println("teardown");
    }
}
