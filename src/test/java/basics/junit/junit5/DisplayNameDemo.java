package basics.junit.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DisplayNameDemo {

    private  Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @AfterEach
    void destroy(){
        calculator = null;
    }

    @Test
    @DisplayName("3➕2 ==5")
    void testAdd() {
        //failure messages at the end. No need to evaluate message if test passes
        //No need to add public now
        assertEquals(5, calculator.add(2, 3), () -> "2 + 3 = " + (2 + 3));
    }

    @Test
    //@DisplayName("fancy name for subtract")
    void test_Subtraction_demo() {
       assertEquals(1, calculator.subtract(3, 2), () -> "custom failure message");
    }

    @Test
    @DisplayName("2*3 == 6")
    void testMultiply() {
        assertEquals(6, calculator.multiply(3, 2), () -> "custom failure message");
    }

}
