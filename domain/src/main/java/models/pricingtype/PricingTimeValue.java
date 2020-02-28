package models.pricingtype;

public class PricingTimeValue {


    private final Types pricingTimeType;
    private final int time;
    private final double value;

    public Types getPricingTimeType() {
        return pricingTimeType;
    }

    public int getTime() {
        return time;
    }

    public double getValue() {
        return value;
    }

    public  enum  Types{
        TYPE_UNTIL ,
        TYPE_EACH,
        TYPE_FIXED
    }
    public PricingTimeValue(Types pricingTimeType,int time, double value) {

        this.pricingTimeType = pricingTimeType;
        this.time = time;
        this.value = value;
    }
}
