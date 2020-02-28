package models;

import models.calculator.PricingCalculatorEach;
import models.calculator.PricingCalculatorUntil;
import repository.PricingTypeRepository;

public class PricingType1 implements PricingType {

    private PricingTypeRepository repository;

    public PricingType1(PricingTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public double calculate(int timeInMinutes) {

        var pricingTypeData = repository.getPricingTypeData(this);
        var calculator =new PricingCalculatorUntil();
        calculator.setNext(new PricingCalculatorEach());

        return calculator.calculate(timeInMinutes, pricingTypeData);




/*
        switch (timeInMinutes) {
            case 3 * 60:
                return 10.0;
            case 14 * 60:
                return 20.0;
            case 3 * 24 * 60:
                return 30.0;
            default:
                return 0;
        }*/


    }
}
