package xylembackend.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import xylembackend.search.dao.PlantDao;
import xylembackend.search.model.Plant;

@Service
public class PlantService {

    private final PlantDao plantDao;

    @Autowired
    public PlantService(@Qualifier("fakeDao") PlantDao plantDao) {
        this.plantDao = plantDao;
    }
    public int addPlant(Plant plant) {
        return plantDao.insertPlant(plant);
    }
}