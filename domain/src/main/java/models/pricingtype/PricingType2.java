package models.pricingtype;

public class PricingType2 implements PricingType {
    @Override
    public double calculate(int timeInMinutes) {
        switch (timeInMinutes){
            case (1 * 60) :
                return 5.0;
            case(4 * 60):
                return 20.0;
            case 12 * 60:
                return 60.0;
            case 30 * 24 *60:
                return 3600;
            default:
                return 0;
        }
    }
}
