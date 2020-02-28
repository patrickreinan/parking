package services;

import models.pricingtype.PricingType;
import util.Result;

public interface SimulationService {

     Result calculate(PricingType pricingType, int minutes);
}
