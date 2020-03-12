package domain.repositories;

import domain.models.pricingtype.PricingType;
import domain.util.Result;

import java.util.ArrayList;
import java.util.UUID;

public interface PricingTypeRepository {
    PricingType getById(UUID id) throws Exception;

    Result<PricingType[]> getAll();
}
