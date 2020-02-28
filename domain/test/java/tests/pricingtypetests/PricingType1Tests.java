package tests.pricingtypetests;

import models.PricingTimeValue;
import models.PricingType;
import models.PricingType1;
import models.PricingTypeData;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import repository.PricingTypeRepository;
import services.SimulationService;
import services.SimulationServiceImpl;
import tests.TimeBuilder;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class PricingType1Tests extends PricingTypeTests {


    public PricingType1Tests(int timeInMinutes, double expectedResult) {
        super(timeInMinutes, expectedResult);
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
                                        .toMinutes(), 40.00}
                }

        );

    }


    @Override
    public PricingType getPricingType() {

        return new PricingType1(new PricingTypeRepository() {
            @Override
            public PricingTypeData getPricingTypeData(PricingType1 pricingType1) {


                return new PricingTypeData(
                        new PricingTimeValue[]{
                                new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 1 * 60, 1),
                                new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 2 * 60, 2),
                                new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 12 * 60, 10),
                                new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 24 * 60, 10)
                        });
            }

        });
    }

}
