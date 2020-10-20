package xylembackend.search.model;

import java.util.UUID;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Table;
// import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;

// @Entity
// @Table(
//     name="fakeLikedDao", 
//     uniqueConstraints=
//        @UniqueConstraint(columnNames={"userId", "plantId"})
// )
public class LikedPlant {

    private final UUID id;
    private final String userId;
    private final String plantId;
    private final String uniqueId;

    public LikedPlant(@JsonProperty("id") UUID id, @JsonProperty("userId") String userId, @JsonProperty("plantId") String plantId, @JsonProperty("uniqueId") String uniqueId) {
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