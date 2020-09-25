package xylembackend.search.dao;

import xylembackend.search.model.Plant;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Plant> getPlant(UUID id) {
        return DB.stream()
                .filter(plant -> plant.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePlant(UUID id) {
        Optional<Plant> plantSingle = getPlant(id);
        if (plantSingle.isEmpty()) {
            return 0;
        } 
        DB.remove(plantSingle.get());
        return 1;
    }

    @Override
    public int updatePlant(UUID id, Plant updatedPlant) {
        return getPlant(id)
                .map(p -> {
                    int plantIndex = DB.indexOf(p);
                    if (plantIndex >= 0) {
                        DB.set(plantIndex, new Plant(id, updatedPlant.getUserId(), updatedPlant.getCommonName(), updatedPlant.getScientificName(), updatedPlant.getFamilyCommonName(), updatedPlant.getFamily(), updatedPlant.getGenus(), updatedPlant.getYear(), updatedPlant.getImageUrl()));
                        return 1;
                    }
                    else {
                        return 0;
                    }
                })
                .orElse(0);
    }
}