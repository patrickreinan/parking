package services;

import util.Result;

public interface AppSimulationService {

    Result calculate(int time, Class pricingTypeClass);
}
