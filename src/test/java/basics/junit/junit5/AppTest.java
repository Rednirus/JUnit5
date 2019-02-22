package basics.junit.junit5;

import org.junit.jupiter.api.*;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("executed "+System.currentTimeMillis());
        assertTrue( true );
    }
}
