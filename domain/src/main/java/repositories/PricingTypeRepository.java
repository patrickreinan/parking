package repositories;

import models.pricingtype.PricingType;

public interface PricingTypeRepository {
    PricingType getPricingTypeByTypeName(String typeName) throws Exception;
}
