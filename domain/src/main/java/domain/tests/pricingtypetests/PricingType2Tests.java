package domain.tests.pricingtypetests;

import domain.models.pricingtype.*;
import domain.services.pricingtype.PricingType;
import domain.services.pricingtype.PricingType2;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.time.TimeBuilder;

import java.util.Arrays;
import java.util.UUID;

@RunWith(value = Parameterized.class)
public class PricingType2Tests extends PricingTypeTests {


    public PricingType2Tests(int timeInMinutes, double expectedResult) throws Exception {
        super(timeInMinutes, expectedResult);
    }

    @Parameterized.Parameters(name = "{index}: PricingType2Tests.calculate({0})={1}")
    public static Iterable<Object[]> data() {

        var builder = new TimeBuilder();

        return Arrays.asList(new Object[][]{
                        {
                                builder
                                        .setHours(1)
                                        .toMinutes(), 5.0},
                        {
                                builder
                                        .reset()
                                        .setHours(4)
                                        .toMinutes(), 20.0},
                        {
                                builder.reset()
                                        .setHours(12)
                                        .toMinutes(), 60.00},
                        {
                                builder.reset()
                                        .setDays(30)
                                        .toMinutes(), 3600.00}
                }
        );
    }

    @Override
    public PricingType getPricingType() throws Exception {

        var pricingTypeData = new PricingTypeData(
                UUID.randomUUID(),
                new PricingTimeValue[]{
                        new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 1 * 60, 5)
                }, PricingType2.class);

        return new PricingType2(pricingTypeData);


    }

}