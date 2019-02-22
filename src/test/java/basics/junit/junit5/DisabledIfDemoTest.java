package basics.junit.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.condition.JRE.*;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

@DisplayName("Demo for Conditional Disabling the tests")
@Tag("functional")
public class DisabledIfDemoTest {

    @Test
    @EnabledOnJre({JAVA_8, JAVA_9, JAVA_10})
    @DisabledOnOs(WINDOWS)
    public void runOnCondition()
    {
        System.out.println("executed "+System.currentTimeMillis());
        assertTrue( true );
    }

    @EnabledIf("2 * 3 == 6")
    @DisabledIf("'str'.length==4")
    @Test
    void runOnExpression(){
        System.out.println("runOnExpression "+System.currentTimeMillis());
    }
}
