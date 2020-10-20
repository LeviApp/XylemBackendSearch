package xylembackend.search.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import xylembackend.search.dao.LikedPlantDao;
import xylembackend.search.model.LikedPlant;

@Service
public class LikedPlantService {
    private final likedplantDao;

    @Autowired
    public LikedPlantService(@Qualifier("fakeDao") LikedPlantDao likedplantDao) {
        this.likedplantDao = likedplantDao;
    }
    public int addLikedPlant(LikedPlant plant) {
        return likedplantDao.insertLikedPlant(plant);
    }

    public List<LikedPlant> getAllLikedPlants() {
        return likedplantDao.allLikedPlants();
    }

    public Optional<LikedPlant> getLikedPlant(UUID id) {
        return likedplantDao.getLikedPlant(id);
    }

    public int deleteLikedPlant(UUID id) {
        return likedplantDao.deleteLikedPlant(id);
    }

    public int updateLikedPlant(UUID id, LikedPlant newLikedPlant) {
        return likedplantDao.updateLikedPlant(id, newLikedPlant);
    }
}