package app.tests;

import domain.models.pricingtype.PricingType;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;


public class ApplicationSimulationNonParametrizedTests extends ApplicationSimulationTests {

    public ApplicationSimulationNonParametrizedTests() {
        super();
    }

    @Test
    public void calculate_value_pricingtype_notfound() {
        var time = 1;

        var invalidPricingType = new PricingType() {
            @Override
            public UUID getId() {
                return UUID.randomUUID();
            }

            @Override
            public double calculate(int timeInMinutes) {
                return 0;
            }
        };

        var value = appSimulationService.calculate(time, invalidPricingType.getId());

        Assert.assertFalse(value.isSuccess());

    }

    @Test
    public void get_all_pricing_types() {

        var count = 2;

        var result= appSimulationService.getAllPricingTypes();

        Assert.assertTrue(result.isSuccess());
        Assert.assertTrue(result.getValue().get().length==count);

    }
}
