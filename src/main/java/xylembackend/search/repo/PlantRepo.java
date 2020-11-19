package xylembackend.search.repo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import xylembackend.search.model.Plant;

// This will be AUTO IMPLEMENTED by Spring into a Bean called plantRepository
// CRUD refers Create, Read, Update, Delete

public interface PlantRepo extends JpaRepository<Plant, Integer> {

    @Query(value = "SELECT PLANT.id, PLANT.user_id, PLANT.common_name, PLANT.scientific_name, PLANT.family_common_name, PLANT.family, PLANT.genus, PLANT.year, PLANT.image_url FROM PLANT LEFT JOIN LIKEDPLANT ON PLANT.id = LIKEDPLANT.plant_id AND LIKEDPLANT.liked = ?1 GROUP BY PLANT.id ORDER BY COUNT(LIKEDPLANT.liked) DESC, PLANT.common_name", nativeQuery = true)
    public List<Plant> orderByLikesDesc(Boolean bool);

    @Query(value = "SELECT PLANT.id, PLANT.user_id, PLANT.common_name, PLANT.scientific_name, PLANT.family_common_name, PLANT.family, PLANT.genus, PLANT.year, PLANT.image_url FROM PLANT LEFT JOIN LIKEDPLANT ON PLANT.id = LIKEDPLANT.plant_id AND LIKEDPLANT.liked = ?1 GROUP BY PLANT.id ORDER BY COUNT(LIKEDPLANT.liked), PLANT.common_name", nativeQuery = true)
    public List<Plant> orderByLikesAsc(Boolean bool);

    @Query(value = "SELECT * FROM PLANT ORDER BY scientific_name", nativeQuery = true)
    public List<Plant> orderByScientificNameAsc();
    
    @Query(value = "SELECT * FROM PLANT ORDER BY scientific_name DESC", nativeQuery = true)
    public List<Plant> orderByScientificNameDesc();

    @Query(value = "SELECT * FROM PLANT ORDER BY common_name", nativeQuery = true)
    public List<Plant> orderByCommonNameAsc();
    
    @Query(value = "SELECT * FROM PLANT ORDER BY common_name DESC", nativeQuery = true)
    public List<Plant> orderByCommonNameDesc();

    @Query(value = "SELECT * FROM PLANT ORDER BY family_common_name", nativeQuery = true)
    public List<Plant> orderByFamilyCommonNameAsc();
    
    @Query(value = "SELECT * FROM PLANT ORDER BY family_common_name DESC", nativeQuery = true)
    public List<Plant> orderByFamilyCommonNameDesc();

    @Query(value = "SELECT * FROM PLANT ORDER BY family", nativeQuery = true)
    public List<Plant> orderByFamilyAsc();
    
    @Query(value = "SELECT * FROM PLANT ORDER BY family DESC", nativeQuery = true)
    public List<Plant> orderByFamilyDesc();

}
