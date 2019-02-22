package basics.junit.junit5;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DependencyInjectionDemo {

    @Test
    @DisplayName("TestReporter demo")
    void repeatedTestWIthTestReporter(TestReporter testReporter) {
        Map<String, String> myMap = new HashMap();
        myMap.put("myKey","myValue");
        testReporter.publishEntry(myMap);
    }

    @Tag("my-tag")
    @Test
    void test(TestInfo testInfo){
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @RepeatedTest(5)
    void repeatedTest(RepetitionInfo repetitionInfo) {
       assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(5)
    void repeatedTest(RepetitionInfo repetitionInfo, TestReporter testReporter) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
        Map<String, String> myMap = new HashMap();
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        myMap.put("myKey" + currentRepetition, "myValue" + currentRepetition);
        testReporter.publishEntry(myMap);
    }
}
