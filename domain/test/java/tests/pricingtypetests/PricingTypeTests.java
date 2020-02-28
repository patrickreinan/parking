package tests.pricingtypetests;

import models.pricingtype.PricingType;
import org.junit.Assert;
import org.junit.Test;
import services.SimulationService;
import services.SimulationServiceImpl;

public abstract class PricingTypeTests {
    private final int timeInMinutes;
    private final double expectedResult;
    private SimulationService service;
    private PricingType pricingType;

    public abstract  PricingType getPricingType();

    public PricingTypeTests(int timeInMinutes, double expectedResult) {

        this.timeInMinutes = timeInMinutes;
        this.expectedResult = expectedResult;
        initialize();

    }

    private void initialize() {

        pricingType = getPricingType();
        service = new SimulationServiceImpl();

    }

    @Test
    public void calculate_price() {

        //arrange, act
        var result = service.calculate(pricingType, timeInMinutes);

        //assert...
        Assert.assertTrue(result.getValue().get()==expectedResult);
        Assert.assertTrue(result.isSuccess());

    }
}
