package xylembackend.search.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import xylembackend.search.dao.DislikedPlantDao;
import xylembackend.search.model.DislikedPlant;

@Service
public class DislikedPlantService {
    private final DislikedPlantDao DislikedplantDao;

    @Autowired
    public DislikedPlantService(@Qualifier("fakeDislikedDao") DislikedPlantDao DislikedplantDao) {
        this.DislikedplantDao = DislikedplantDao;
    }
    public int addDislikedPlant(DislikedPlant plant) {
        return DislikedplantDao.insertDislikedPlant(plant);
    }

    public List<DislikedPlant> getAllDislikedPlants() {
        return DislikedplantDao.allDislikedPlants();
    }

    public Optional<DislikedPlant> getDislikedPlant(UUID id) {
        return DislikedplantDao.getDislikedPlant(id);
    }

    public int deleteDislikedPlant(UUID id) {
        return DislikedplantDao.deleteDislikedPlant(id);
    }

    public int updateDislikedPlant(UUID id, DislikedPlant newDislikedPlant) {
        return DislikedplantDao.updateDislikedPlant(id, newDislikedPlant);
    }
}