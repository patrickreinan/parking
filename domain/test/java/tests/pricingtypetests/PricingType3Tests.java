package tests.pricingtypetests;

import models.pricingtype.PricingType;
import models.pricingtype.PricingType3;
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
                                .toMinutes(), 32.00}
                }
        );
    }

    @Override
    public PricingType getPricingType() {
        return new PricingType3();
    }


}