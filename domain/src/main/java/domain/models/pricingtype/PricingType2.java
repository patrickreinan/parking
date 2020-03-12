package domain.models.pricingtype;

import domain.services.calculator.PricingCalculatorEach;

import java.util.UUID;

public class PricingType2 implements PricingType {

    private final PricingTypeData pricingTypeData;
    private final UUID id;

    public PricingType2(UUID id,PricingTypeData pricingTypeData) {
        this.id = id;
        this.pricingTypeData = pricingTypeData;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public double calculate(int timeInMinutes) {
        var calculator = new PricingCalculatorEach();
        return calculator.calculate(timeInMinutes, pricingTypeData);

    }

}
