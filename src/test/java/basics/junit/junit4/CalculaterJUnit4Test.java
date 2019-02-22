package basics.junit.junit4;

import basics.junit.junit5.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculaterJUnit4Test {
    private final Calculator calculator = new Calculator();

    @org.junit.Test(expected = ArithmeticException.class)
    public void divideByZeroJunit4() {
        int d = 1/0;
        calculator.divide(1, 1);
    }

    @Test()
    public void addInJunit4() {
        int result = calculator.add(2, 3);
        Assert.assertEquals("2 + 3 = " + (2 + 3)+ " does not match expected value", 5, result);
    }

    @Test(timeout = 10)
    public void fibonacci() throws InterruptedException {
      Thread.sleep(20);
      calculator.fibonacci(10);
    }

}
