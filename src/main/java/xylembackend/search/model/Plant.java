package xylembackend.search.model;

import java.util.UUID;
// import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Plant {
    private final UUID id;
    private final String userId;
    private final String commonName;

    // @Column(unique=true)
    private final String scientificName;

    private final String familyCommonName;
    private final String family;
    private final String genus;
    private final int year;
    private final String imageUrl;


    public Plant(@JsonProperty("id") UUID id, @JsonProperty("userId") String userId, @JsonProperty("commonName") String commonName, @JsonProperty("scientificName") String scientificName, @JsonProperty("familyCommonName") String familyCommonName, @JsonProperty("family") String family, @JsonProperty("genus") String genus, @JsonProperty("year") int year, @JsonProperty("imageUrl") String imageUrl) {
        this.id = id;
        this.userId = userId;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.familyCommonName = familyCommonName;
        this.family = family;
        this.genus = genus;
        this.year = year;
        this.imageUrl = imageUrl;
    }

    public UUID getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getFamilyCommonName() {
        return familyCommonName;
    }

    public String getFamily() {
        return family;
    }

    public String getGenus() {
        return genus;
    }

    public int getYear() {
        return year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}