package tests;

import org.junit.Test;
import tests.TimeBuilder;

import static org.junit.Assert.assertTrue;

public class TimeBuilderNonParameterizedTests {
    @Test
    public void reset_test(){

        var builder = new TimeBuilder();

        builder.setDays(1)
                .setHours(3)
                .setMinutes(2);


        builder.reset();

        assertTrue(builder.toMinutes()==0);


    }
}
