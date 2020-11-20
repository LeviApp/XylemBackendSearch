package xylembackend.search.repo;

import java.util.List;
import xylembackend.search.model.Plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xylembackend.search.model.RecommendedPlant;
import xylembackend.search.model.RecommendedPlantData;

public interface RecommendedPlantRepo extends JpaRepository<RecommendedPlant, Integer> {
    
    
    // @Query(value = "SELECT PLANT.id, PLANT.user_id, PLANT.common_name, PLANT.scientific_name, PLANT.family_common_name, PLANT.family, PLANT.genus, PLANT.year, PLANT.image_url, recommended_by, recommended_to FROM RECOMMENDEDPLANT INNER JOIN PLANT ON PLANT.id = RECOMMENDEDPLANT.plant_id AND recommended_to = ?1 AND plant_id = ?2", nativeQuery = true)
    // public List<Plant> orderByLikesDesc(Boolean bool);

    // @Query(value = "SELECT common_name, plant_id, recommended_to, COUNT(plant_id) FROM RECOMMENDEDPLANT INNER JOIN PLANT ON PLANT.id = RECOMMENDEDPLANT.plant_id AND recommended_to = 1 GROUP BY plant_id, recommended_to ORDER BY plant_id", nativeQuery = true)
    // public List<Plant> orderByLikesDesc(Boolean bool);

    @Query(value = "SELECT PLANT.id, PLANT.user_id, PLANT.common_name, PLANT.scientific_name, PLANT.family_common_name, PLANT.family, PLANT.genus, PLANT.year, PLANT.image_url, COUNT(plant_id) AS total_recommends, recommended_to FROM RECOMMENDEDPLANT INNER JOIN PLANT ON PLANT.id = RECOMMENDEDPLANT.plant_id AND recommended_to = ?1 GROUP BY plant_id, recommended_to ORDER BY PLANT.id", nativeQuery = true)
    public List<RecommendedPlantData> listRecommended(String userid);
}