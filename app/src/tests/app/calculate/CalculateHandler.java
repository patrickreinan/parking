package app.calculate;

import app.util.Handler;
import domain.repositories.PricingTypeRepository;
import domain.services.SimulationService;
import domain.util.Result;

public class CalculateHandler implements Handler<CalculateRequest, CalculateResponse> {

    private final SimulationService service;
    private final PricingTypeRepository repository;

    public CalculateHandler(SimulationService service, PricingTypeRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @Override
    public CalculateResponse handle(CalculateRequest request) {
        try {

            var pricingType = repository.getById(request.getPricingTypeId());
            var result = service.calculate(pricingType, request.getTime());
            return new CalculateResponse(result.getValue().get());

        } catch (Exception e) {

            return new CalculateResponse(new String[] {e.getMessage()});
        }
    }
}
