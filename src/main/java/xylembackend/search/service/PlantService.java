// package xylembackend.search.service;

// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.stereotype.Service;

// import xylembackend.search.dao.PlantDao;
// import xylembackend.search.model.Plant;

// @Service
// public class PlantService {

//     private final PlantDao plantDao;

//     @Autowired
//     public PlantService(@Qualifier("fakeDao") PlantDao plantDao) {
//         this.plantDao = plantDao;
//     }
//     public int addPlant(Plant plant) {
//         return plantDao.insertPlant(plant);
//     }

//     public List<Plant> getAllPlants() {
//         return plantDao.allPlants();
//     }

//     public Optional<Plant> getPlant(UUID id) {
//         return plantDao.getPlant(id);
//     }

//     public int deletePlant(UUID id) {
//         return plantDao.deletePlant(id);
//     }

//     public int updatePlant(UUID id, Plant newPlant) {
//         return plantDao.updatePlant(id, newPlant);
//     }
    
// }