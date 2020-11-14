package xylembackend.search.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xylembackend.search.model.LikedPlant;

public interface LikedPlantRepo extends JpaRepository<LikedPlant, Integer> {

    @Query(value = "SELECT COUNT(plant_id) FROM LIKEDPLANT WHERE plant_id=?1 AND liked = true", nativeQuery = true)
    public Long countLikedPlants(Integer plantid);

    // @Query("SELECT COUNT(l) FROM LikedPlant l WHERE l.plant_id=?1 AND l.liked = false")
    // public Long countDisikedPlants(Integer plantid);
}