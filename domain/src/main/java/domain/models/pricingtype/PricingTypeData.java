package domain.models.pricingtype;

public class PricingTypeData {


    private PricingTimeValue[] pricingTimes;

    public PricingTypeData(PricingTimeValue[] pricingTimes) {
        this.pricingTimes = pricingTimes;
    }

    public PricingTimeValue[] getPricingTimes() {
        return pricingTimes;
    }
}
