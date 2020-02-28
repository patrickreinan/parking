package models.calculator;

import models.PricingTimeValue;
import models.PricingTypeData;

import java.util.Arrays;

public class PricingCalculatorEach extends PricingCalculator {

    @Override
    public double calculate(int timeInMinutes, PricingTypeData pricingTypeData, double initialPrice) {

        var pricingTimeValues = Arrays.stream(pricingTypeData.getPricingTimes())
                .filter(x -> x.getPricingTimeType() == PricingTimeValue.Types.TYPE_EACH)
                .toArray();

        var price = 0.0;
        var timeToCalculate = timeInMinutes;

        while (timeToCalculate > 0) {
            for (Object item : pricingTimeValues) {

                //arrumar esta alocação de memória...
                var pricingTimeValue = (PricingTimeValue) item;
                if (pricingTimeValue.getTime() > timeToCalculate)
                    timeToCalculate = 0;
                else
                    timeToCalculate -= pricingTimeValue.getTime();

                price += pricingTimeValue.getValue();

            }
        }

        price += initialPrice;

        if (hasNext())
            return next.calculate(timeToCalculate, pricingTypeData, price);
        else
            return price;


    }
}
