package domain.services.pricingtype;

import domain.models.pricingtype.PricingTypeData;
import domain.services.calculator.PricingCalculatorEach;
import domain.services.calculator.PricingCalculatorUntil;

public class PricingType1 extends PricingType {


    public PricingType1(PricingTypeData pricingTypeData) throws Exception {
        super(pricingTypeData);
    }

    @Override
    public double calculate(int timeInMinutes) {

        var calculator =new PricingCalculatorUntil();
        calculator.setNext(new PricingCalculatorEach());

        return calculator.calculate(timeInMinutes, pricingTypeData);

    }
}
