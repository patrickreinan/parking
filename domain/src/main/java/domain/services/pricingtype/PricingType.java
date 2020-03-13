package domain.services.pricingtype;

import domain.models.pricingtype.PricingTypeData;

import java.util.UUID;

public abstract class PricingType {

    protected final PricingTypeData pricingTypeData;

    public PricingType(PricingTypeData pricingTypeData)  {
        this.pricingTypeData = pricingTypeData;


    }

    public abstract double calculate(int timeInMinutes);
}
