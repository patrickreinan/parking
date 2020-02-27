package models;

public class PricingType1 implements PricingType {
    @Override
    public double calculate(int timeInMinutes) {

        switch (timeInMinutes) {
            case 3 * 60:
                return 10.0;
            case 14 * 60:
                return 20.0;
            case 3 * 24 * 60 :
                return 30.0;
            default:
                return 0;
        }


    }
}
