package app.tests;

import domain.models.pricingtype.*;
import domain.util.Result;
import org.junit.runners.Parameterized;
import domain.repositories.PricingTypeRepository;
import util.time.TimeBuilder;

import java.util.*;

public class InMemoryPricingTypeRepository implements PricingTypeRepository {

    private final PricingType[] array = new PricingType[]{

            new PricingType1(UUID.fromString("00000000-0000-0000-0000-000000000001"), new PricingTypeData(
                    new PricingTimeValue[]{
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 1 * 60, 1),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 2 * 60, 2),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 12 * 60, 10),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 24 * 60, 10)
                    })),

            new PricingType2(UUID.fromString("00000000-0000-0000-0000-000000000002"), new PricingTypeData(
                    new PricingTimeValue[]{
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 1 * 60, 5)
                    }))

    };

    @Override
    public PricingType getById(UUID uuid) throws Exception {

        var pricingType = Arrays.stream(array)
                .filter(x -> x.getId().equals(uuid))
                .findFirst();

        if (pricingType == null)
            throw new Exception("PricingType not found");

        return pricingType.get();
    }

    @Override
    public Result<PricingType[]> getAll() {
        return new Result(Optional.of(array));
    }
}
