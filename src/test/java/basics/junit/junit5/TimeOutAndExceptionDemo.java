package basics.junit.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeOutAndExceptionDemo {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName(" Divide by zero ==> ArithmeticException")
    void divideByZero() {
        //int d = 1 / 0;
        Executable executableCode = () -> calculator.divide(1, 0);
        Exception exception = assertThrows(ArithmeticException.class, executableCode);
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Ensure Fibonacci computation is 'fast enough'")
    void fibonacci(){
        long current = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis()- current >20)
                break;
        }
        Assertions.assertTimeout(ofMillis(1), () -> calculator.fibonacci(30));
    }
}
