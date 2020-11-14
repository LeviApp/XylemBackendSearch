package xylembackend.search.model;

import java.util.UUID;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;


// @Entity
// @Table(
//     name="fakeLikedDao", 
//     uniqueConstraints=
//        @UniqueConstraint(columnNames={"userId", "plantId"})
// )
@Table(name = "LIKEDPLANT")
@Entity(name = "LIKEDPLANT")
public class LikedPlant {

    private Integer id;    
    private String user_id;
    private Integer plant_id;
    private Boolean liked;

    public LikedPlant() {

    }
    
    public LikedPlant(Integer id, String user_id, Integer plant_id, Boolean liked) {
        this.id = id;
        this.user_id = user_id;
        this.plant_id = plant_id;
        this.liked = liked;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuser_id() {
        return user_id;
    }

    public void setuser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getplant_id() {
        return plant_id;
    }

    public void setplant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
}