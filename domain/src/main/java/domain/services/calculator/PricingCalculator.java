package domain.services.calculator;

import domain.models.pricingtype.PricingTypeData;

public abstract class PricingCalculator {


    protected PricingCalculator next;


    public void setNext(PricingCalculator next) {
        this.next = next;
    }

    protected boolean hasNext() {
        return next != null;
    }

    public double calculate(int timeInMinutes, PricingTypeData pricingTypeData) {
        return calculate(timeInMinutes, pricingTypeData, 0.0);
    }

    public abstract double calculate(int timeInMinutes, PricingTypeData pricingTypeData, double initialPrice);


}
