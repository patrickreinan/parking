package app.tests.calculate;

import app.calculate.CalculateRequest;
import domain.models.pricingtype.PricingType;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;


public class CalculateNonParametrizedTests extends CalculateTests {

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

        var value = handler.handle(new CalculateRequest(time, invalidPricingType.getId()));

        Assert.assertFalse(value.isSuccess());

    }


}
