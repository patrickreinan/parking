package tests.util;

import models.pricingtype.*;
import repositories.PricingTypeRepository;

public class InMemoryPricingTypeRepository implements PricingTypeRepository {


    @Override
    public PricingType getPricingTypeByTypeName(String typeName) throws Exception {

        if (typeName.equals(PricingType1.class.getTypeName())) {
            var pricingTypeData = new PricingTypeData(
                    new PricingTimeValue[]{
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 1 * 60, 1),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 2 * 60, 2),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_UNTIL, 12 * 60, 10),
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 24 * 60, 10)
                    });

            return new PricingType1(pricingTypeData);
        }


        if (typeName.equals(PricingType2.class.getTypeName())) {
            var pricingTypeData = new PricingTypeData(
                    new PricingTimeValue[]{
                            new PricingTimeValue(PricingTimeValue.Types.TYPE_EACH, 1 * 60, 5)
                    });

            return new PricingType2(pricingTypeData);
        }

        throw new Exception("PricingType not found");
    }
}
