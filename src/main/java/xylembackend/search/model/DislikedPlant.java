package xylembackend.search.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DislikedPlant {
    private final UUID id;
    private final String userId;
    private final String plantId;
    private final String uniqueId;

    public DislikedPlant(@JsonProperty("id") UUID id, @JsonProperty("userId") String userId, @JsonProperty("plantId") String plantId, @JsonProperty("uniqueId") String uniqueId) {
        this.id = id;
        this.userId = userId;
        this.plantId = plantId;
        this.uniqueId = uniqueId;

    }

    public UUID getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPlantId() {
        return plantId;
    }

    public String getUniqueId() {
        return uniqueId;
    }
}