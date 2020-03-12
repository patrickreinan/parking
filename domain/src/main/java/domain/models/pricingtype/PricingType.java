package domain.models.pricingtype;

import java.util.UUID;

public interface PricingType {

    UUID getId();
    double calculate(int timeInMinutes);
}
