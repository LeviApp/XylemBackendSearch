// package xylembackend.search.dao;

// import xylembackend.search.model.LikedPlant;

// import java.util.ArrayList;
// import java.util.UUID;

// import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

// /**
//  * FakePlantDataAccessService
//  */

//  @Repository("fakeLikedDao")
// public class FakeLikedPlantDataAccessService implements LikedPlantDao {

//     private static List<LikedPlant> DB = new ArrayList<>();

//     @Override 
//     public int insertLikedPlant(UUID id, LikedPlant plant) {
//         DB.add(new LikedPlant(id, plant.getUserId(), plant.getPlantId(), plant.getLiked()));
//         return 1;
//     }

//     @Override 
//     public List<LikedPlant> allLikedPlants() {
//         return DB;
//     }

//     @Override
//     public Optional<LikedPlant> getLikedPlant(UUID id) {
//         return DB.stream()
//                 .filter(plant -> plant.getId().equals(id))
//                 .findFirst();
//     }

//     @Override
//     public int deleteLikedPlant(UUID id) {
//         Optional<LikedPlant> plantSingle = getLikedPlant(id);
//         if (plantSingle.isEmpty()) {
//             return 0;
//         } 
//         DB.remove(plantSingle.get());
//         return 1;
//     }

//     @Override
//     public int updateLikedPlant(UUID id, LikedPlant updatedPlant) {
//         return getLikedPlant(id)
//                 .map(p -> {
//                     int plantIndex = DB.indexOf(p);
//                     if (plantIndex >= 0) {
//                         DB.set(plantIndex, new LikedPlant(id, updatedPlant.getUserId(), updatedPlant.getPlantId(), updatedPlant.getLiked()));
//                         return 1;
//                     }
//                     else {
//                         return 0;
//                     }
//                 })
//                 .orElse(0);
//     }
// }