package xylembackend.search.dao;

import xylembackend.search.model.RecommendedPlant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecommendedPlantDao {
    int insertRecommendedPlant(UUID id, RecommendedPlant recommendedplant);

    default int insertRecommendedPlant(RecommendedPlant recommendedplant) {
        UUID id = UUID.randomUUID();
        return insertRecommendedPlant(id, recommendedplant);
    }

    List<RecommendedPlant> allRecommendedPlants();

    Optional<RecommendedPlant> getRecommendedPlant(UUID id);

    int deleteRecommendedPlant(UUID id);

    int updateRecommendedPlant(UUID id, RecommendedPlant plant);

}