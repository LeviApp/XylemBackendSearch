package xylembackend.search.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import xylembackend.search.dao.RecommendedPlantDao;
import xylembackend.search.model.RecommendedPlant;
import xylembackend.search.model.RecommendedPlantData;
import xylembackend.search.repo.RecommendedPlantRepo;

@Service
public class RecommendedPlantService {

    @Autowired
    private RecommendedPlantRepo recommendedplantRepo;

    public List<RecommendedPlant> getAllRecommendedPlants() {
        return recommendedplantRepo.findAll();
    }

    public void addRecommendedPlant(RecommendedPlant recommendedPlant) {
        recommendedplantRepo.save(recommendedPlant);
    }

    public RecommendedPlant getRecommendedPlant(Integer id) {
        return recommendedplantRepo.findById(id).get();
    }

    public void deleteRecommendedPlant(Integer id) {
        recommendedplantRepo.deleteById(id);
    }

    public List<RecommendedPlantData> listRecommended(String userid) {
        System.out.println("Help");

        System.out.println(recommendedplantRepo.listRecommended(userid));

        return recommendedplantRepo.listRecommended(userid);
    }
}