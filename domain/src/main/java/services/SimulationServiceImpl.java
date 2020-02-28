package services;

import models.pricingtype.PricingType;
import util.Result;

import java.util.Optional;

public class SimulationServiceImpl implements SimulationService {
    @Override
    public Result calculate(PricingType pricingType, int minutes) {

        if(minutes<0){
            return new Result(new String[] { "Minutes may be equal or greather than 0"} );
        }else if(minutes==0)
            return  new Result(Optional.of(0.0));

        return new Result(Optional.of(pricingType.calculate(minutes)));
    }
}
