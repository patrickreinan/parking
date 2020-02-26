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
public class PricingType3Tests {

    private final int timeInMinutes;
    private final double expectedResult;
    private SimulationService service;
    private PricingType pricingType;

    public PricingType3Tests(int timeInMinutes, double expectedResult) {
        this.timeInMinutes = timeInMinutes;
        this.expectedResult = expectedResult;

    }

    @Parameterized.Parameters(name = "{index}: PricingType2Tests.calculate({0})={1}")
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

    @Test
    public void calculate_price() {

        //arrange, act
        var result = service.calculate(pricingType, timeInMinutes);

        //assert...
        Assert.assertTrue(result == expectedResult);
    }

    @Before
    public void setUp() throws Exception {
        service = Mockito.mock(SimulationService.class);
        pricingType = Mockito.mock(PricingType.class);
        Mockito.when(service.calculate(pricingType, timeInMinutes)).thenReturn(expectedResult);
    }
}