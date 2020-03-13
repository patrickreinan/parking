package app.tests;

import domain.models.pricingtype.*;
import domain.repositories.PricingTypeDataRepository;
import domain.services.pricingtype.PricingType1;
import domain.services.pricingtype.PricingType2;
import domain.util.Result;

import java.util.*;

public class InMemoryPricingTypeRepository implements PricingTypeDataRepository {

    private final PricingTypeData[] array = new PricingTypeData[]{

            new PricingTypeData(
                    UUID.fromString("00000000-0000-0000-0000-000000000001"),
                    new PricingTimeValue[]{
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 1 * 60, 1),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 2 * 60, 2),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 12 * 60, 10),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 24 * 60, 10)
                    }, PricingType1.class),

            new PricingTypeData(UUID.fromString("00000000-0000-0000-0000-000000000002"),
                    new PricingTimeValue[]{
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 1 * 60, 5)
                    }, PricingType2.class)

    };

    @Override
    public PricingTypeData getById(UUID uuid) throws Exception {

        var pricingType = Arrays.stream(array)
                .filter(x -> x.getId().equals(uuid))
                .findFirst();

        if (pricingType == null)
            throw new Exception("PricingType not found");

        return pricingType.get();
    }

    @Override
    public Result<PricingTypeData[]> getAll() {
        return new Result(Optional.of(array));
    }
}
