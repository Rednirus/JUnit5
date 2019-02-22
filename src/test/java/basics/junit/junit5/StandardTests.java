
package basics.junit.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Unit Tests")
class StandardTests {

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
	@DisplayName("➕")
	void add() {
		assertEquals(5, calculator.add(2, 3), () -> "custom failure message");
	}

	@Test
	@DisplayName("subtract")
	void subtract() {
		assertEquals(1, calculator.subtract(3, 2), () -> "custom failure message");
	}

	@Test
	@DisplayName("n ➗ 0 → ArithmeticException")
	void divideByZero() {
		Executable executableCode = () -> calculator.divide(1, 0);
		Exception exception = assertThrows(ArithmeticException.class, executableCode);
		assertEquals("/ by zero", exception.getMessage());
	}

	@Test
	@DisplayName("Divide operation should verify arguments and then execute")
	void divide_By_Zero_Assert_All() {
		int a = 4;
		int b = 0;
		assertAll("should check arguments and execute",
				() -> assertTrue(a >0),
				() -> assertTrue(b >0),
				() -> assertEquals(2, calculator.divide(a, b)));
	}

	@Test
	public void demoLinesEqual() {
		List<String> expected = asList("Java", "\\d+", "JUnit");
		List<String> actual = asList("Java", "11", "JUnit");
		assertLinesMatch(expected, actual);
	}

}
