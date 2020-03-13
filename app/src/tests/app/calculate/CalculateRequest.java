package app.calculate;

import java.util.UUID;

public class CalculateRequest {
    private final int time;
    private final UUID pricingTypeDataId;

    public int getTime() {
        return time;
    }

    public UUID getPricingTypeDataId() {
        return pricingTypeDataId;
    }

    public CalculateRequest(int time, UUID pricingTypeDataId) {
        this.time = time;
        this.pricingTypeDataId = pricingTypeDataId;
    }


}
