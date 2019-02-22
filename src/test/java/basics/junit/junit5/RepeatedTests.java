package basics.junit.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RepeatedTests {
    private  final Calculator calculator = new Calculator();
    @BeforeEach
    void setUp(RepetitionInfo repetitionInfo){
        System.out.println("Before called " + repetitionInfo.getCurrentRepetition());
    }

    @AfterEach
    void destroy(RepetitionInfo repetitionInfo){
        System.out.println("destroy called " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(5)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

}
