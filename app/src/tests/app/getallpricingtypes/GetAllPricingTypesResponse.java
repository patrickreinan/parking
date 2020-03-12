package app.getallpricingtypes;

import app.util.Response;

public class GetAllPricingTypesResponse extends Response<PricingTypeDto[]> {

    public GetAllPricingTypesResponse(PricingTypeDto[] pricingTypeDtos) {
        super(pricingTypeDtos);
    }

    public GetAllPricingTypesResponse(String[] messages) {
        super(messages);
    }
}
