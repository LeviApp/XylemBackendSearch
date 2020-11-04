package xylembackend.search.dao;

import xylembackend.search.model.RecommendedPlant;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fakeRecommendedDao")
public class FakeRecommendedPlantAccessService implements RecommendedPlantDao {
    private static List<RecommendedPlant> DB = new ArrayList<>();

    @Override 
    public int insertRecommendedPlant(UUID id, RecommendedPlant recommendedplant) {
        DB.add(new RecommendedPlant(id, recommendedplant.getRecommendedBy(), recommendedplant.getRecommendedTo(), recommendedplant.getPlantId()));
        return 1;
    }

    @Override 
    public List<RecommendedPlant> allRecommendedPlants() {
        return DB;
    }

    @Override
    public Optional<RecommendedPlant> getRecommendedPlant(UUID id) {
        return DB.stream()
                .filter(RecommendedPlant -> RecommendedPlant.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteRecommendedPlant(UUID id) {
        Optional<RecommendedPlant> RecommendedPlantSingle = getRecommendedPlant(id);
        if (RecommendedPlantSingle.isEmpty()) {
            return 0;
        } 
        DB.remove(RecommendedPlantSingle.get());
        return 1;
    }

    @Override
    public int updateRecommendedPlant(UUID id, RecommendedPlant updatedecommendedlant) {
        return getRecommendedPlant(id)
                .map(p -> {
                    int RecommendedPlantIndex = DB.indexOf(p);
                    if (RecommendedPlantIndex >= 0) {
                        DB.set(RecommendedPlantIndex, new RecommendedPlant(id, updatedecommendedlant.getRecommendedBy(), updatedecommendedlant.getRecommendedTo(), updatedecommendedlant.getPlantId()));
                        return 1;
                    }
                    else {
                        return 0;
                    }
                })
                .orElse(0);
    }
    
}