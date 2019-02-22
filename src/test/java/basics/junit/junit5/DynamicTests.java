package basics.junit.junit5;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTests {
    Calculator calculator = new Calculator();

    @TestFactory
    Stream<DynamicNode> testMultiplyOnfirstTenIntegers() {
        return IntStream.iterate(1, n -> n + 1).limit(10)//
                .mapToObj(n -> dynamicTest(
                        "Calculator::"+n+"==calculator.multiply("+n+", "+n+")/"+n+"",
                        () -> assertEquals(n, calculator.multiply(n, n)/n)));
    }

    @TestFactory
    Stream<DynamicNode> testChars() {
        return Stream.of("A", "B", "C", "Z")//
                .map(str -> dynamicTest("test" + str+" < Z", () -> assertTrue(str.charAt(0) < 'Z')));
    }
}
