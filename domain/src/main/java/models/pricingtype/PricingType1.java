package models.pricingtype;

import models.calculator.PricingCalculatorEach;
import models.calculator.PricingCalculatorUntil;

public class PricingType1 implements PricingType {


    private final PricingTypeData pricingTypeData;

    public PricingType1(PricingTypeData pricingTypeData) {

        this.pricingTypeData = pricingTypeData;
    }

    @Override
    public double calculate(int timeInMinutes) {

        var calculator =new PricingCalculatorUntil();
        calculator.setNext(new PricingCalculatorEach());

        return calculator.calculate(timeInMinutes, pricingTypeData);

    }
}
