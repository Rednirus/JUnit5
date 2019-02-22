package basics.junit.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("non-functional")
public class NonFunctionalTest {

    @DisplayName("Load test")
    @Tag("load")
    @Test
    void test1(){
        System.out.println(" load test");
    }

    @DisplayName("Stress test")
    @Tag("stress")
    @Test
    void test2(){
        System.out.println(" stress test");
    }

    @DisplayName("Performance test")
    @Tag("performance")
    @Test
    void test3(){
        System.out.println(" performance test");
    }
}
