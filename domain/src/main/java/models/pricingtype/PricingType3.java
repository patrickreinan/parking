package models.pricingtype;

import models.calculator.PricingCalculatorEach;
import models.calculator.PricingCalculatorUntil;

public class PricingType3 implements PricingType {


    private PricingTypeData pricingTypeData;

    public PricingType3(PricingTypeData pricingTypeData) {
        this.pricingTypeData = pricingTypeData;
    }

    @Override
    public double calculate(int timeInMinutes) {
        var calculator =new PricingCalculatorUntil();
        calculator.setNext(new PricingCalculatorEach());

        return calculator.calculate(timeInMinutes, pricingTypeData);
    }
}
