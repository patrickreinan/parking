package models.pricingtype;

import models.PricingTimeValue;

import java.util.ArrayList;

public class PricingTypeData {


    private PricingTimeValue[] pricingTimes;

    public PricingTypeData(PricingTimeValue[] pricingTimes) {
        this.pricingTimes = pricingTimes;
    }

    public PricingTimeValue[] getPricingTimes() {
        return pricingTimes;
    }
}
