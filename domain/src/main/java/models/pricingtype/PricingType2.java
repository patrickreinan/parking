package models.pricingtype;

import models.calculator.PricingCalculator;
import models.calculator.PricingCalculatorEach;

public class PricingType2 implements PricingType {

    private final PricingTypeData pricingTypeData;

    public PricingType2(PricingTypeData pricingTypeData) {

        this.pricingTypeData = pricingTypeData;
    }

    @Override
    public double calculate(int timeInMinutes) {
        var calculator = new PricingCalculatorEach();
        return calculator.calculate(timeInMinutes, pricingTypeData);

    }

}
