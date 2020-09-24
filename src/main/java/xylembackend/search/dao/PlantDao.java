package xylembackend.search.dao;

import xylembackend.search.model.Plant;
import java.util.UUID;
public interface PlantDao {
    int insertPlant(UUID id, Plant plant);

    default int insertPlant(Plant plant) {
        UUID id = UUID.randomUUID();
        return insertPlant(id, plant);
    }
}