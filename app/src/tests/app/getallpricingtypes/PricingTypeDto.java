package app.getallpricingtypes;

import java.util.UUID;

public class PricingTypeDto {
    public UUID getId() {
        return id;
    }

    private UUID id;

    public PricingTypeDto(UUID id) {
        this.id = id;
    }
}
