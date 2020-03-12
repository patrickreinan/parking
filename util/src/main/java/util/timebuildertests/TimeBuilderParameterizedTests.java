package util.timebuildertests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.time.TimeBuilder;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class TimeBuilderParameterizedTests {


    private final int days;
    private final int hours;
    private final int minutes;
    private final int expected;

    public TimeBuilderParameterizedTests(int days, int hours, int minutes, int expected) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Days: {0}, Hours: {1}, Minutes: {2} = {3}")
    public static Iterable<Object[]> data() {

        return Arrays.asList(new Object[][]{
                        {0, 3, 0, 180},
                        {0, 14, 0, 840},
                        {3, 24, 0, 5760}
                }

        );

    }

    @Test
    public void build_minutes(){


        var result = new TimeBuilder()
                .setDays(days)
                .setHours(hours)
                .setMinutes(minutes)
                .toMinutes();


        Assert.assertTrue(result==expected);


    }



}