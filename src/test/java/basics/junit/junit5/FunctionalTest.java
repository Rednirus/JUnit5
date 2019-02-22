package basics.junit.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("functional")
class FunctionalTest {

    @DisplayName("functional test 1")
    @Test
    void test1(){
        System.out.println("functional test 1");
    }

    @DisplayName("functional test 2")
    @Test
    void test2(){
        System.out.println("functional test 2");
    }

    @DisplayName("functional test 3")
    @Test
    void test3(){
        System.out.println("functional test 3");
    }
}
