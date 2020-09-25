package xylembackend.search.dao;

import xylembackend.search.model.Plant;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FakePlantDataAccessService
 */

 @Repository("fakeDao")
public class FakePlantDataAccessService implements PlantDao {

    private static List<Plant> DB = new ArrayList<>();

    @Override 
    public int insertPlant(UUID id, Plant plant) {
        DB.add(new Plant(id, plant.getUserId(), plant.getCommonName(), plant.getScientificName(), plant.getFamilyCommonName(), plant.getFamily(), plant.getGenus(), plant.getYear(), plant.getImageUrl()));
        return 1;
    }

    @Override 
    public List<Plant> allPlants() {
        return DB;
    }
}