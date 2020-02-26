package  tests;

import models.PricingType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import services.SimulationService;
import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class PricingType1Tests extends  PricingTypeTests {


    public PricingType1Tests(int timeInMinutes, double expectedResult) {
        super(timeInMinutes, expectedResult);
    }

    @Parameterized.Parameters(name = "{index}: PricingType1Tests.calculate({0})={1}")

    public static Iterable<Object[]> data() {

        var builder = new TimeBuilder();

        return Arrays.asList(new Object[][]{
                        {builder
                                .setHours(3)
                                .toMinutes(), 10.0},
                        {
                                builder
                                        .reset()
                                        .setHours(14)
                                        .toMinutes(), 20.0},
                        {
                                builder
                                        .reset()
                                        .setDays(3)
                                        .toMinutes(), 30.00}
                }

        );

    }


    @Override
    public PricingType getPricingType() {
        return Mockito.mock(PricingType.class);
    }
}
