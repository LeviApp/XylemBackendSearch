package xylembackend.search.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xylembackend.search.model.RecommendedPlant;

public interface RecommendedPlantRepo extends JpaRepository<RecommendedPlant, Integer> {

}