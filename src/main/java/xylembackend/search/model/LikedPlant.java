package xylembackend.search.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LikedPlant {

    private final UUID id;
    private final String userId;
    private final String plantId;

    public LikedPlant(@JsonProperty("id") UUID id, @JsonProperty("userId") String userId, @JsonProperty("plantId") String plantId) {
        this.id = id;
        this.userId = userId;
        this.plantId = plantId;
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
}