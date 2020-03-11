package services;

import models.pricingtype.PricingType;
import models.pricingtype.PricingType1;

public interface AppSimulationService {
    PricingType getPricingType(Class pricingTypeClass);

    double calculate(int time, PricingType pricingType);
}
