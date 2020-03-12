package domain.services;

import domain.models.pricingtype.PricingType;
import domain.util.Result;

public interface SimulationService {

     Result<Double> calculate(PricingType pricingType, int minutes);
}
