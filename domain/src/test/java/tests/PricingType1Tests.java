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
public class PricingType1Tests {


    private final int timeInMinutes;
    private final double expectedResult;
    private SimulationService service;
    private PricingType pricingType;

    public PricingType1Tests(int timeInMinutes, double expectedResult) {

        this.timeInMinutes = timeInMinutes;
        this.expectedResult = expectedResult;
        setupMock();

    }

    private void setupMock() {

        service = Mockito.mock(SimulationService.class);
        pricingType = Mockito.mock(PricingType.class);
        Mockito.when(service.calculate(pricingType, timeInMinutes)).thenReturn(expectedResult);

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

    @Test
    public void calculate_price() {

        //arrange, act
        var result = service.calculate(pricingType, timeInMinutes);

        //assert...
        Assert.assertTrue(result==expectedResult);

    }

}
