package app.tests.getallpricingtypes;

import app.getallpricingtypes.GetAllPricingTypesHandler;
import app.getallpricingtypes.GetAllPricingTypesRequest;
import app.tests.InMemoryPricingTypeRepository;
import org.junit.Assert;
import org.junit.Test;

public class GetAllPricingTypesTests {

    private final GetAllPricingTypesHandler handler;

    public GetAllPricingTypesTests() {
        this.handler = new GetAllPricingTypesHandler(new InMemoryPricingTypeRepository());
    }

    @Test
    public void get_all_pricing_types() {

        var count = 2;

        var result= handler.handle(new GetAllPricingTypesRequest());

        Assert.assertTrue(result.isSuccess());
        Assert.assertTrue(result.getValue().length==count);

    }
}
