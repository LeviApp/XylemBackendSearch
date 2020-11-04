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

    // @Column(unique=true)
    private final String userId;

    // @Column(unique=true)
    private final String plantId;
    
    private final Boolean liked;

    public LikedPlant(@JsonProperty("id") UUID id, @JsonProperty("userId") String userId, @JsonProperty("plantId") String plantId, @JsonProperty("liked") Boolean liked) {
        this.id = id;
        this.userId = userId;
        this.plantId = plantId;
        this.liked = liked;

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

    public Boolean getLiked() {
        return liked;
    }
}