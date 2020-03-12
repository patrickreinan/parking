package app.services;

import domain.models.pricingtype.PricingType;
import domain.repositories.PricingTypeRepository;
import domain.services.SimulationService;
import domain.util.Result;

import java.util.ArrayList;
import java.util.UUID;

public class AppSimulationServiceImpl implements AppSimulationService {

    private SimulationService service;
    private PricingTypeRepository repository;

    public AppSimulationServiceImpl(SimulationService service, PricingTypeRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @Override
    public Result calculate(int time, UUID pricingTypeId) {


        try {
            var pricingType = repository.getById(pricingTypeId);
            return service.calculate(pricingType, time);
        } catch (Exception e) {

            return new Result(e.getMessage());
        }

    }

    @Override
    public Result<PricingType[]> getAllPricingTypes() {
        return  repository.getAll();
    }
}
