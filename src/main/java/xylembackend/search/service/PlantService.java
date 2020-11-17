package xylembackend.search.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import xylembackend.search.dao.PlantDao;
import xylembackend.search.model.Plant;
import xylembackend.search.repo.PlantRepo;

@Service
public class PlantService {
   
    @Autowired
    private PlantRepo plantRepo;

    public List<Plant> getAllPlants() {
        return plantRepo.findAll();
    }

    public void addPlant(Plant plant) {
        plantRepo.save(plant);
    }

    public Plant getPlant(Integer id) {
        return plantRepo.findById(id).get();
    }

    public void deletePlant(Integer id) {
        plantRepo.deleteById(id);
    }

    public List<Plant> orderByLikesDesc(Boolean bool) {
        return plantRepo.orderByLikesDesc(bool);
    }

    public List<Plant> orderByLikesAsc(Boolean bool) {
        return plantRepo.orderByLikesAsc(bool);
    }
}