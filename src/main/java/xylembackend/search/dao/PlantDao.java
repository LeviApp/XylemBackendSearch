package xylembackend.search.dao;

import xylembackend.search.model.Plant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface PlantDao {
    int insertPlant(UUID id, Plant plant);

    default int insertPlant(Plant plant) {
        UUID id = UUID.randomUUID();
        return insertPlant(id, plant);
    }

    List<Plant> allPlants();

    Optional<Plant> getPlant(UUID id);

    int deletePlant(UUID id);

    int updatePlant(UUID id, Plant plant);
}