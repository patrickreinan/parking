package models.pricingtype;

public class PricingType3 implements PricingType {

    @Override
    public double calculate(int timeInMinutes) {
        switch (timeInMinutes){
            case (1 * 60) :
                return 1.0;
            case(3 * 60):
                return 3.0;
            case 12 * 60:
                return 12.0;
            case 14 *60:
                return 22;
            case 3 * 24 * 60:
                return 32.0;
            default:
                return 0;
        }
    }
}
