package tests;

import models.pricingtype.PricingType;
import models.pricingtype.PricingType1;
import org.junit.Assert;
import org.junit.Test;
import services.AppSimulationService;
import services.AppSimulationServiceImpl;
import services.SimulationServiceImpl;
import tests.util.InMemoryPricingTypeRepository;

public class SimulationTests {

    private AppSimulationService appSimulationService;

    public SimulationTests() {
        var simulationService = new SimulationServiceImpl();
        var repository = new InMemoryPricingTypeRepository() ;
        this.appSimulationService = new AppSimulationServiceImpl(simulationService, repository);
    }

    @Test
    public void calculate_value_pricingtype1() {
        var time = 1;
        var expectedValue = 1.0;

        var value = appSimulationService.calculate(time, PricingType1.class);

        Assert.assertTrue(value.getValue().get() == expectedValue);

    }


    @Test
    public void calculate_value_pricingtype_notfound() {
        var time = 1;

        var invalidPricingType = new PricingType() {
            @Override
            public double calculate(int timeInMinutes) {
                return 0;
            }
        };

        var value = appSimulationService.calculate(time, invalidPricingType.getClass());

        Assert.assertFalse(value.isSuccess());

    }
}
