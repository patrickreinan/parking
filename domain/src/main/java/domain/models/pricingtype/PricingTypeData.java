package domain.models.pricingtype;

import java.util.UUID;

public class PricingTypeData {




    private final UUID id;
    private final PricingTimeValue[] pricingTimes;
    private final Class pricingTypeClass;



    public PricingTypeData(UUID id, PricingTimeValue[] pricingTimes, Class pricingTypeClass) {
        this.id = id;
        this.pricingTimes = pricingTimes;
        this.pricingTypeClass = pricingTypeClass;
    }

    public PricingTimeValue[] getPricingTimes() {
        return pricingTimes;
    }

    public UUID getId() {
        return id;
    }


    public Class getPricingTypeClass() {
        return pricingTypeClass;
    }
}
