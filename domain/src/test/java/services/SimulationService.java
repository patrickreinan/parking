package services;

import models.PricingType;

public interface SimulationService {

     double calculate(PricingType pricingType, int minutes);
}
