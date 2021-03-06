package app.tests.calculate;

import app.calculate.CalculateHandler;
import app.tests.InMemoryPricingTypeRepository;
import domain.repositories.PricingTypeDataRepository;
import domain.services.SimulationService;
import domain.services.SimulationServiceImpl;

public class CalculateTests {
    protected final PricingTypeDataRepository repository;
    protected final SimulationService service;
    protected final CalculateHandler handler;

    public CalculateTests() {

        this.repository = new InMemoryPricingTypeRepository();
        this.service = new SimulationServiceImpl();
        this.handler = new CalculateHandler(service,repository);
    }
}
