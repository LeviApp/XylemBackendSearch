package xylembackend.search.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import xylembackend.search.dao.RecommendedPlantDao;
import xylembackend.search.model.RecommendedPlant;

@Service
public class RecommendedPlantService {
    private final RecommendedPlantDao recommendedplantDao;

    @Autowired
    public RecommendedPlantService(@Qualifier("fakeDao") RecommendedPlantDao recommendedplantDao) {
        this.recommendedplantDao = recommendedplantDao;
    }
    public int addRecommendedPlant(RecommendedPlant recommendedPlant) {
        return recommendedplantDao.insertRecommendedPlant(recommendedPlant);
    }

    public List<RecommendedPlant> getAllRecommendedPlants() {
        return recommendedplantDao.allRecommendedPlants();
    }

    public Optional<RecommendedPlant> getRecommendedPlant(UUID id) {
        return recommendedplantDao.getRecommendedPlant(id);
    }

    public int deletePlant(UUID id) {
        return recommendedplantDao.deleteRecommendedPlant(id);
    }

    public int updatePlant(UUID id, RecommendedPlant newPlant) {
        return recommendedplantDao.updateRecommendedPlant(id, newPlant);
    }
}