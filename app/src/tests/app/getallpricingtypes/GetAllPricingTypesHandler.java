package app.getallpricingtypes;

import app.util.Handler;
import domain.repositories.PricingTypeRepository;
import domain.services.SimulationService;

public class GetAllPricingTypesHandler implements Handler<GetAllPricingTypesRequest, GetAllPricingTypesResponse> {


    private final PricingTypeRepository repository;

    public GetAllPricingTypesHandler(PricingTypeRepository repository) {
        this.repository = repository;
    }


    @Override
    public GetAllPricingTypesResponse handle(GetAllPricingTypesRequest getAllPricingTypesRequest) {
        try {

            var pricingTypes = repository.getAll().getValue().get();
            var result = new PricingTypeDto[pricingTypes.length];

            for (int index = 0; index < pricingTypes.length; index++)
                result[index] = new PricingTypeDto(pricingTypes[index].getId());

            return new GetAllPricingTypesResponse(result);
        } catch (Exception ex) {
            return new GetAllPricingTypesResponse(new String[]{ex.getMessage()});
        }
    }
}
