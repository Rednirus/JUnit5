package basics.junit.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Ordering the test cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderingTestsDemo {

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
    @DisplayName("Order 1")
    @Order(1)
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), () -> "2 + 3 = " + (2 + 3));
    }

    @Test
    @DisplayName("Order 2")
    @Order(2)
    void testSubtraction() {
          assertEquals(1, calculator.subtract(3, 2), () -> "custom failure message");
    }

    @Test
    @DisplayName("Order 3")
    @Order(3)
    void testMultiply() {
        assertEquals(6, calculator.multiply(3, 2), () -> "custom failure message");
    }

}
