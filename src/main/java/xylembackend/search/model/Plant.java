package xylembackend.search.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Plant {
    private final UUID id;
    private final String user_id;
    private final String common_name;
    private final String scientific_name;
    private final String family_common_name;
    private final String family;
    private final String genus;
    private final int year;
    private final String image_url;
    private final int likes;
    private final int dislikes;


    public Plant(@JsonProperty("id") UUID id, @JsonProperty("user_id") String user_id, @JsonProperty("common_name") String common_name, @JsonProperty("scientific_name") String scientific_name, @JsonProperty("family_common_name") String family_common_name, @JsonProperty("family") String family, @JsonProperty("genus") String genus, @JsonProperty("year") int year, @JsonProperty("image_url") String image_url,  @JsonProperty("likes") int likes,  @JsonProperty("dislikes") int dislikes) {
        this.id = id;
        this.user_id = user_id;
        this.common_name = common_name;
        this.scientific_name = scientific_name;
        this.family_common_name = family_common_name;
        this.family = family;
        this.genus = genus;
        this.year = year;
        this.image_url = image_url;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public UUID getId() {
        return id;
    }

    public String getUserId() {
        return user_id;
    }

    public String getCommonName() {
        return common_name;
    }

    public String getScientificName() {
        return scientific_name;
    }

    public String getFamilyCommonName() {
        return family_common_name;
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
        return image_url;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return year;
    }

}