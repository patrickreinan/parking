package services;

import models.pricingtype.PricingType;
import repositories.PricingTypeRepository;
import util.Result;

public class AppSimulationServiceImpl implements AppSimulationService {

    private SimulationService service;
    private PricingTypeRepository repository;

    public AppSimulationServiceImpl(SimulationService service, PricingTypeRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @Override
    public Result calculate(int time, Class pricingTypeClass) {


        try {
            var pricingType = repository.getPricingTypeByTypeName(pricingTypeClass.getTypeName());
            return service.calculate(pricingType, time);
        } catch (Exception e) {

            return new Result(e.getMessage());
        }

    }
}
