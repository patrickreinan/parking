package app.getallpricingtypes;

import app.util.Handler;
import domain.repositories.PricingTypeDataRepository;


public class GetAllPricingTypesHandler implements Handler<GetAllPricingTypesRequest, GetAllPricingTypesResponse> {


    private final PricingTypeDataRepository repository;

    public GetAllPricingTypesHandler(PricingTypeDataRepository repository) {
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
