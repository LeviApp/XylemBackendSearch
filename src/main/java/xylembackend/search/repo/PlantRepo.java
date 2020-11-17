package xylembackend.search.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import antlr.collections.List;
import xylembackend.search.model.Plant;

// This will be AUTO IMPLEMENTED by Spring into a Bean called plantRepository
// CRUD refers Create, Read, Update, Delete

public interface PlantRepo extends JpaRepository<Plant, Integer> {

    // @Query(value = "SELECT *, COUNT(plant_id) FROM PLANT WHERE plant_id=?1 AND liked = false JOIN LIKEDPLANT ON PLANT.id = LIKEDPLANT.plant_id GROUP BY id", nativeQuery = true)
    // public List<Plant> combineDislikedPlantsCount(Integer plantid);
}
