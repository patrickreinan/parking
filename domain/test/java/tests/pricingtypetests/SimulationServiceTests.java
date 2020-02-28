package tests.pricingtypetests;

import models.pricingtype.PricingType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import services.SimulationService;
import services.SimulationServiceImpl;

public class SimulationServiceTests {


    private SimulationService simulationService;

    public SimulationServiceTests() {
        this.simulationService = new SimulationServiceImpl();
    }

    @Test
    public void minutes_zero_returns_zero() {

        //arrange...
        var pricingType = Mockito.mock(PricingType.class);
        Mockito.when(pricingType.calculate(0)).thenReturn(0.0);

        //act...
        var result = simulationService.calculate(pricingType, 0);

        //assert...
        Assert.assertTrue(result.isSuccess() && result.getValue().get() == 0);

    }


    @Test
    public void minutes_less_than_zero_returns_error() {

        //arrange...
        var pricingType = Mockito.mock(PricingType.class);

        //act...
        var result = simulationService.calculate(pricingType, -1);

        //assert...
        Assert.assertFalse(result.isSuccess());
        Assert.assertTrue(result.getMessages().length == 1);

        System.out.println(result.getMessages()[0]);

    }
}
