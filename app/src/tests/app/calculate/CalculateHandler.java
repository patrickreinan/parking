package app.calculate;

import app.util.Handler;
import domain.services.pricingtype.PricingType;
import domain.models.pricingtype.PricingTypeData;
import domain.repositories.PricingTypeDataRepository;
import domain.services.SimulationService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class CalculateHandler implements Handler<CalculateRequest, CalculateResponse> {

    private final SimulationService service;
    private final PricingTypeDataRepository repository;

    public CalculateHandler(SimulationService service, PricingTypeDataRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    private PricingType pricingTypeFromData(PricingTypeData pricingTypeData) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        var c = pricingTypeData.getPricingTypeClass().getConstructor(PricingTypeData.class);
        if (c == null)
            return null;
        c.setAccessible(true);
        return (PricingType) c.newInstance(new Object[]{pricingTypeData});


    }

    @Override
    public CalculateResponse handle(CalculateRequest request) {
        try {

            var pricingTypeData = repository.getById(request.getPricingTypeDataId());
            var pricingType = pricingTypeFromData(pricingTypeData);

            var result = service.calculate(pricingType, request.getTime());
            if (result.getValue().isPresent())
                return new CalculateResponse(result.getValue().get());
            else
                throw new Exception("Could not calculate value");

        } catch (Exception e) {

            return new CalculateResponse(new String[]{e.getMessage()});
        }
    }
}
