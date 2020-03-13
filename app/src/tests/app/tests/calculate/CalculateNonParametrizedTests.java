package app.tests.calculate;

import app.calculate.CalculateRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;


public class CalculateNonParametrizedTests extends CalculateTests {

    @Test
    public void calculate_value_pricingtypedata_notfound() throws Exception {
        var time = 1;

   var value = handler.handle(new CalculateRequest(time, UUID.randomUUID()));

        Assert.assertFalse(value.isSuccess());

    }


}
