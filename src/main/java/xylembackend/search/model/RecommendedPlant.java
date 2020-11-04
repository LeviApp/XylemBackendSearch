package xylembackend.search.model;

import java.util.UUID;
// import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendedPlant {
    private final UUID id;

    // @Column(unique=true)
    private final String recommendedBy;

    // @Column(unique=true)
    private final String recommendedTo;

    private final String plantId;


    public RecommendedPlant(@JsonProperty("id") UUID id, @JsonProperty("recommendedBy") String recommendedBy, @JsonProperty("recommendedTo") String recommendedTo, @JsonProperty("plantId") String plantId) {
        this.id = id;
        this.recommendedBy = recommendedBy;
        this.recommendedTo = recommendedTo;
        this.plantId = plantId;
    }

    public UUID getId() {
        return id;
    }

    public String getRecommendedBy() {
        return recommendedBy;
    }

    public String getRecommendedTo() {
        return recommendedTo;
    }

    public String getPlantId() {
        return plantId;
    }
}