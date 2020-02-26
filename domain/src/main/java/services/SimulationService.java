package services;

import models.PricingType;
import util.Result;

public interface SimulationService {

     Result calculate(PricingType pricingType, int minutes);
}
