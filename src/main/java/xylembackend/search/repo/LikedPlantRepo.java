package xylembackend.search.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xylembackend.search.model.LikedPlant;
import xylembackend.search.model.Plant;

public interface LikedPlantRepo extends JpaRepository<LikedPlant, Integer> {

    @Query(value = "SELECT COUNT(plant_id) AS likes FROM LIKEDPLANT WHERE plant_id=?1 AND liked = true UNION SELECT COUNT(plant_id) AS dislikes FROM LIKEDPLANT WHERE plant_id=?1 AND liked = false", nativeQuery = true)
    public List<Long> countLikedPlants(Integer plantid);


}