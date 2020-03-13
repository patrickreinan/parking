package domain.repositories;

import domain.models.pricingtype.PricingTypeData;
import domain.util.Result;

import java.util.UUID;

public interface PricingTypeDataRepository {
    PricingTypeData getById(UUID id) throws Exception;

    Result<PricingTypeData[]> getAll();
}
