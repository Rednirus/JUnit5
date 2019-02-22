
package basics.junit.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
import static org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@IntegrationTest
@Execution(CONCURRENT)//SAME_THREAD
@ExtendWith(LoggingExtension.class)
class ParameterizedFibonacciTests {

	private final Calculator calculator = new Calculator();

	@ParameterizedTest(name = "fib({0}) → {1}")
	@CsvSource({
			"0,  0",
			"1,  1",
			"2,  1",
			"3,  2",
			"4,  3",
			"5,  5",
			"40, 102334155",
			"41, 165580141",
			"42, 267914296",
			//"43, 433494437",
			//"44, 701408733",
			//"45, 1134903170",
			//"46, 1836311903",
			//"47, 2971215073",
			//"48, 4807526976"
	})
	void fibonacci(long n, long expected) {
		assertEquals(expected, calculator.fibonacci(n));
	}

	@Test
	@DisplayName("Ad: This test does not need parameters")
	void add() {
		assertEquals(5, calculator.add(2, 3), () -> "custom failure message");
	}

}
