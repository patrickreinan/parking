package repository;

import models.PricingType1;
import models.PricingTypeData;

public interface PricingTypeRepository {

    PricingTypeData getPricingTypeData(PricingType1 pricingType1);
}
