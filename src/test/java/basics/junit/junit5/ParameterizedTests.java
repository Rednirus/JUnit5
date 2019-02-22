package basics.junit.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterizedTests {
    private final Calculator calculator = new Calculator();
    @DisplayName("Test Demo CSV Source")
    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "2, 3, 6"
    })
    void testMultiply(int a, int b, int result) {
        assertEquals( result, calculator.multiply(a, b), "results does not match expected result");
    }


    @DisplayName("Test Demo Method Source")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @MethodSource ("argumentProvider1")
    void argumentProvider(int a, int b, int result) {
        assertEquals( result, calculator.multiply(a, b), "results does not match expected result");
    }

    @DisplayName("Test Demo Value Source")
    @ParameterizedTest
    	@ValueSource(strings = { //
    			"mom", //
    			"dad", //
    			"radar", //
    			"racecar", //
    			"able was I ere I saw elba"//
    	})
    void palindromes(String candidate) {
        Assertions.assertTrue(StringUtils.isPalindrome(candidate));
    }

    private static Stream<Arguments> argumentProvider1() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(2, 3, 6)
        );
    }

    static Stream<String> palindromes() {
        return Stream.of("mom",
                "dad",
                "radar",
                "racecar",
                "121",
                "able was I ere I saw elba"//
        );
    }
}
