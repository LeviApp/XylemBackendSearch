package xylembackend.search.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xylembackend.search.model.LikedPlant;

public interface LikedPlantRepo extends JpaRepository<LikedPlant, Integer> {

}