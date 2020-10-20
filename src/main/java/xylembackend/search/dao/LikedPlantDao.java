package xylembackend.search.dao;

import xylembackend.search.model.LikedPlant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LikedPlantDao {
    int insertLikedPlant(UUID id, LikedPlant plant);

    default int insertLikedPlant(LikedPlant plant) {
        UUID id = UUID.randomUUID();
        return insertLikedPlant(id, plant);
    }

    List<LikedPlant> allLikedPlants();

    Optional<LikedPlant> getLikedPlant(UUID id);

    int deleteLikedPlant(UUID id);

    int updateLikedPlant(UUID id, LikedPlant plant);
}