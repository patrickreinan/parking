package domain.services.pricingtype;

import domain.models.pricingtype.PricingTypeData;
import domain.services.calculator.PricingCalculatorEach;

public class PricingType2 extends PricingType {

    public PricingType2(PricingTypeData pricingTypeData) throws Exception {
        super(pricingTypeData);
    }

    @Override
    public double calculate(int timeInMinutes) {
        var calculator = new PricingCalculatorEach();
        return calculator.calculate(timeInMinutes, pricingTypeData);

    }

}
