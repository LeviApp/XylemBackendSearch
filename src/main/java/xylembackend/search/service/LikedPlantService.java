package xylembackend.search.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import xylembackend.search.model.LikedPlant;
import xylembackend.search.repo.LikedPlantRepo;

@Service
public class LikedPlantService {

    @Autowired
    private LikedPlantRepo likedplantRepo;


    public List<LikedPlant> getAllLikedPlants() {
        return likedplantRepo.findAll();
    }

    public void addLikedPlant(LikedPlant likedplant) {
        likedplantRepo.save(likedplant);
    }

    public LikedPlant getLikedPlant(Integer id) {
        return likedplantRepo.findById(id).get();
    }

    public void deleteLikedPlant(Integer id) {
        likedplantRepo.deleteById(id);
    }

    public Long countLikedPlant(Integer plantid) {
        return likedplantRepo.countLikedPlants(plantid);
    }
}