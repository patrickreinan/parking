package tests;

import models.PricingType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import services.SimulationService;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class PricingType2Tests extends  PricingTypeTests {


    public PricingType2Tests(int timeInMinutes, double expectedResult) {
        super(timeInMinutes, expectedResult);
    }

    @Parameterized.Parameters(name = "{index}: PricingType2Tests.calculate({0})={1}")
    public static Iterable<Object[]> data() {

        var builder = new TimeBuilder();

        return Arrays.asList(new Object[][]{
                        {
                                builder
                                        .setHours(1)
                                        .toMinutes(), 5.0},
                        {
                                builder
                                        .reset()
                                        .setHours(4)
                                        .toMinutes(), 20.0},
                        {
                                builder.reset()
                                        .setHours(12)
                                        .toMinutes(), 60.00},
                        {
                                builder.reset()
                                        .setDays(30)
                                        .toMinutes(), 3600.00}
                }
        );
    }

    @Override
    public PricingType getPricingType() {
        return Mockito.mock(PricingType.class);
    }

}