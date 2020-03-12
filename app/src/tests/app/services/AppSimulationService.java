package app.services;

import domain.models.pricingtype.PricingType;
import domain.util.Result;

import java.util.ArrayList;
import java.util.UUID;

public interface AppSimulationService {

    Result<Double> calculate(int time, UUID pricingTypeId);
    Result<PricingType[]> getAllPricingTypes();

}
