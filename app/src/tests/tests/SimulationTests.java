package tests;

import models.pricingtype.PricingTimeValue;
import models.pricingtype.PricingType;
import models.pricingtype.PricingType1;
import models.pricingtype.PricingTypeData;
import org.junit.Assert;
import org.junit.Test;
import services.AppSimulationService;

public class SimulationTests {

    private AppSimulationService appSimulationService;

    public SimulationTests() {
        this.appSimulationService = new AppSimulationService() {
            @Override
            public PricingType getPricingType(Class pricingTypeClass) {
                var pricingTypeData  =  new PricingTypeData(
                        new PricingTimeValue[]{
                                new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 1 * 60, 1),
                                new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 2 * 60, 2),
                                new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 12 * 60, 10),
                                new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 24 * 60, 10)
                        });

                return new PricingType1(pricingTypeData);
            }

            @Override
            public double calculate(int time, PricingType pricingType) {
                return 1;
            }
        };
    }

    @Test
    public void calculate_value_pricingtype1() {
        var time = 1;
        var expectedValue = 1.0;
        var pricingType = appSimulationService.getPricingType(PricingType1.class);

        var value = appSimulationService.calculate(time, pricingType);

        Assert.assertTrue(value==expectedValue );

    }
}
