package app.calculate;

import java.util.UUID;

public class CalculateRequest {
    private final int time;
    private final UUID pricingTypeId;

    public int getTime() {
        return time;
    }

    public UUID getPricingTypeId() {
        return pricingTypeId;
    }

    public CalculateRequest(int time, UUID pricingTypeId) {
        this.time = time;
        this.pricingTypeId = pricingTypeId;
    }


}
