package app.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.time.TimeBuilder;

import java.util.Arrays;
import java.util.UUID;

@RunWith(value = Parameterized.class)
public class ApplicationSimulationParametrizedTests extends ApplicationSimulationTests {


    private final int time;
    private final UUID pricingTypeId;
    private final double expectedValue;


    private final static UUID pricingType1Id = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private final static UUID pricingType2Id = UUID.fromString("00000000-0000-0000-0000-000000000002");


    @Parameterized.Parameters(name = "{index}: simulationService.calculate({0}, {1})={2}")

    public static Iterable<Object[]> data() {

        var builder = new TimeBuilder();

        return Arrays.asList(new Object[][]{
                        {
                                builder
                                        .setHours(3)
                                        .toMinutes(), pricingType1Id, 10.0},
                        {
                                builder
                                        .reset()
                                        .setHours(14)
                                        .toMinutes(), pricingType1Id, 20.0},
                        {
                                builder
                                        .reset()
                                        .setDays(3)
                                        .toMinutes(), pricingType1Id, 40.00},
                        {
                                builder
                                        .reset()
                                        .setHours(1)
                                        .toMinutes(), pricingType2Id, 5.0},
                        {
                                builder
                                        .reset()
                                        .setHours(4)
                                        .toMinutes(), pricingType2Id, 20.0},
                        {
                                builder.reset()
                                        .setHours(12)
                                        .toMinutes(), pricingType2Id, 60.00},
                        {
                                builder.reset()
                                        .setDays(30)
                                        .toMinutes(), pricingType2Id, 3600.00}
                }

        );

    }


    public ApplicationSimulationParametrizedTests(int time, UUID pricingTypeId, double expectedResult) {
        super();

        this.time = time;
        this.pricingTypeId = pricingTypeId;
        this.expectedValue = expectedResult;

    }

    @Test
    public void calculate_value_pricingtype() {

        var value = appSimulationService.calculate(time, pricingTypeId);

        Assert.assertTrue(value.getValue().get() == expectedValue);

    }


}
