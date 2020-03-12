package domain.models.pricingtype;

import domain.services.calculator.PricingCalculatorEach;
import domain.services.calculator.PricingCalculatorUntil;

import java.util.UUID;

public class PricingType1 implements PricingType {


    private final PricingTypeData pricingTypeData;
    private UUID id;

    public PricingType1(UUID id, PricingTypeData pricingTypeData) {
        this.id = id;
        this.pricingTypeData = pricingTypeData;

    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public double calculate(int timeInMinutes) {

        var calculator =new PricingCalculatorUntil();
        calculator.setNext(new PricingCalculatorEach());

        return calculator.calculate(timeInMinutes, pricingTypeData);

    }
}
