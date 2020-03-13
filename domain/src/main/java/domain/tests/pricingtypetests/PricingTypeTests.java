package domain.tests.pricingtypetests;

import domain.services.pricingtype.PricingType;
import org.junit.Assert;
import org.junit.Test;
import domain.services.SimulationService;
import domain.services.SimulationServiceImpl;

public abstract class PricingTypeTests {
    private final int timeInMinutes;
    private final double expectedResult;
    private SimulationService service;
    private PricingType pricingType;

    public abstract  PricingType getPricingType() throws Exception;

    public PricingTypeTests(int timeInMinutes, double expectedResult) throws Exception {

        this.timeInMinutes = timeInMinutes;
        this.expectedResult = expectedResult;
        initialize();

    }

    private void initialize() throws Exception {

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
