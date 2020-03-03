package tests.pricingtypetests;

import models.pricingtype.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tests.TimeBuilder;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class PricingType3Tests extends PricingTypeTests {


    public PricingType3Tests(int timeInMinutes, double expectedResult) {
        super(timeInMinutes, expectedResult);
    }

    @Parameterized.Parameters(name = "{index}: PricingType3Tests.calculate({0})={1}")
    public static Iterable<Object[]> data() {

        var builder = new TimeBuilder();

        return Arrays.asList(new Object[][]{
                        {
                                builder
                                        .setHours(1)
                                        .toMinutes(), 1.0},
                        {
                                builder
                                        .reset()
                                        .setHours(3)
                                        .toMinutes(), 3.0},
                        {
                                builder.reset()
                                        .setHours(12)
                                        .toMinutes(), 12.00},
                        {
                                builder.reset()
                                        .setHours(14)
                                        .toMinutes(), 22.00},
                        {
                                builder.reset()
                                        .setDays(3)
                                        .toMinutes(), 42.00}
                }
        );
    }

    @Override
    public PricingType getPricingType() {


        var timeValue = new PricingTimeValue[13];

        //until
        timeValue[0] = new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 1 * 60, 1);
        timeValue[1] = new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 2 * 60, 2);

        //until + each
        for (int timeInHours = 2; timeInHours <= 12; timeInHours++) {
            timeValue[timeInHours - 1] = new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, timeInHours * 60, timeInHours);
        }

        //after
        timeValue[12] = new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 24 * 60, 10.0);

        var pricingTypeData = new PricingTypeData(
                timeValue);

        return new PricingType3(pricingTypeData);


    }


}