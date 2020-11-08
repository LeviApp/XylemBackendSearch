package xylembackend.search.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import xylembackend.search.model.Plant;

// This will be AUTO IMPLEMENTED by Spring into a Bean called plantRepository
// CRUD refers Create, Read, Update, Delete

public interface PlantRepo extends JpaRepository<Plant, Integer> {

}
