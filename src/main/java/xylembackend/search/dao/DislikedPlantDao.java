package xylembackend.search.dao;

import xylembackend.search.model.DislikedPlant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DislikedPlantDao {
    int insertDislikedPlant(UUID id, DislikedPlant plant);

    default int insertDislikedPlant(DislikedPlant plant) {
        UUID id = UUID.randomUUID();
        return insertDislikedPlant(id, plant);
    }

    List<DislikedPlant> allDislikedPlants();

    Optional<DislikedPlant> getDislikedPlant(UUID id);

    int deleteDislikedPlant(UUID id);

    int updateDislikedPlant(UUID id, DislikedPlant plant);
}