package xylembackend.search.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import jdk.jfr.DataAmount;


@Table(name = "PLANT")
@Entity(name = "PLANT")
public class Plant {
    private Integer id;    
    private String user_id;
    private String common_name;
    private String scientific_name;

    private String family_common_name;
    private String family;
    private String genus;
    private Integer year;
    private String image_url;

    public Plant() {

    }

    public Plant(Integer id, String user_id, String common_name, String scientific_name, String family_common_name, String family, String genus, Integer year, String image_url) {
        this.id = id;
        this.user_id = user_id;
        this.common_name = common_name;
        this.scientific_name = scientific_name;
        this.family_common_name = family_common_name;
        this.family = family;
        this.genus = genus;
        this.year = year;
        this.image_url = image_url;
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

    public String getcommon_name() {
        return common_name;
    }

    public void setcommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getscientific_name() {
        return scientific_name;
    }

    public void setscientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }
    
    public String getfamily_common_name() {
        return family_common_name;
    }
    
    public void setfamily_common_name(String family_common_name) {
        this.family_common_name = family_common_name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getimage_url() {
        return image_url;
    }

    public void setimage_url(String image_url) {
        this.image_url = image_url;
    }

}