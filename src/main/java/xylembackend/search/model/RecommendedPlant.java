package xylembackend.search.model;

import java.util.UUID;
// import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "RECOMMENDEDPLANT")
public class RecommendedPlant {
    private  Integer id;

    // @Column(unique=true)
    private  String recommended_by;

    // @Column(unique=true)
    private String recommended_to;

    private Integer plant_id;

    public RecommendedPlant() {

    }

    public RecommendedPlant(Integer id, String recommended_by, String recommended_to, Integer plant_id) {
        this.id = id;
        this.recommended_by = recommended_by;
        this.recommended_to = recommended_to;
        this.plant_id = plant_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrecommended_by() {
        return recommended_by;
    }

    public void setrecommended_by(String recommended_by) {
        this.recommended_by = recommended_by;
    }

    public String getrecommended_to() {
        return recommended_to;
    }

    public void setrecommended_to(String recommended_to) {
        this.recommended_to = recommended_to;
    }

    public Integer getplant_id() {
        return plant_id;
    }

    public void setplant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }
}