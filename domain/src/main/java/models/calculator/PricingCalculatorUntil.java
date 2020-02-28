package models.calculator;

import models.PricingTimeValue;
import models.pricingtype.PricingTypeData;

import java.util.Arrays;

public class PricingCalculatorUntil extends PricingCalculator {
    @Override
    public double calculate(int timeInMinutes, PricingTypeData pricingTypeData, double initialPrice) {

        var pricingTimeValues = Arrays.stream(pricingTypeData.getPricingTimes())
                .filter(x -> x.getPricingTimeType() == PricingTimeValue.Types.TYPE_UNTIL)
                .toArray();

        var price = 0.0;
        var timeToSubstract = 0;

        for (Object item : pricingTimeValues) {

            //arrumar esta alocação de memória...
            var pricingTimeValue = (PricingTimeValue) item;
            if (pricingTimeValue.getTime() > timeInMinutes)
                return pricingTimeValue.getValue()+ initialPrice;

            price = pricingTimeValue.getValue();
            timeToSubstract = pricingTimeValue.getTime();
        }

        price += initialPrice;

        if (hasNext())
          return  next.calculate(timeInMinutes-timeToSubstract, pricingTypeData, price);
        else
            return price;

    }
}
