package xylembackend.search.dao;

import xylembackend.search.model.DislikedPlant;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * FakePlantDataAccessService
 */

 @Repository("fakeDislikedDao")
public class FakeDislikedPlantDataAccessService implements DislikedPlantDao {

    private static List<DislikedPlant> DB = new ArrayList<>();

    @Override 
    public int insertDislikedPlant(UUID id, DislikedPlant plant) {
        DB.add(new DislikedPlant(id, plant.getUserId(), plant.getPlantId(), plant.getUniqueId()));
        return 1;
    }

    @Override 
    public List<DislikedPlant> allDislikedPlants() {
        return DB;
    }

    @Override
    public Optional<DislikedPlant> getDislikedPlant(UUID id) {
        return DB.stream()
                .filter(plant -> plant.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteDislikedPlant(UUID id) {
        Optional<DislikedPlant> plantSingle = getDislikedPlant(id);
        if (plantSingle.isEmpty()) {
            return 0;
        } 
        DB.remove(plantSingle.get());
        return 1;
    }

    @Override
    public int updateDislikedPlant(UUID id, DislikedPlant updatedPlant) {
        return getDislikedPlant(id)
                .map(p -> {
                    int plantIndex = DB.indexOf(p);
                    if (plantIndex >= 0) {
                        DB.set(plantIndex, new DislikedPlant(id, updatedPlant.getUserId(), updatedPlant.getPlantId(), updatedPlant.getUniqueId()));
                        return 1;
                    }
                    else {
                        return 0;
                    }
                })
                .orElse(0);
    }
}