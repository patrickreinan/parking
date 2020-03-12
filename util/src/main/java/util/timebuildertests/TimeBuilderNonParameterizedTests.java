package util.timebuildertests;

import org.junit.Assert;
import org.junit.Test;
import util.time.TimeBuilder;


import static org.junit.Assert.assertTrue;

public class TimeBuilderNonParameterizedTests {
    @Test
    public void reset_test(){

        var builder = new TimeBuilder();

        builder.setDays(1)
                .setHours(3)
                .setMinutes(2);


        builder.reset();

        Assert.assertTrue(builder.toMinutes()==0);


    }
}
