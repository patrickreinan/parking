package app.tests;

import app.services.AppSimulationService;
import app.services.AppSimulationServiceImpl;
import domain.services.SimulationServiceImpl;

public abstract  class ApplicationSimulationTests {

    protected final AppSimulationService appSimulationService;

    public ApplicationSimulationTests() {

        var simulationService = new SimulationServiceImpl();
        var repository = new InMemoryPricingTypeRepository();

        this.appSimulationService = new AppSimulationServiceImpl(simulationService, repository);

    }
}
