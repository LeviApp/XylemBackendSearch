package xylembackend.search.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xylembackend.search.model.RecommendedPlant;
import xylembackend.search.service.RecommendedPlantService;

@RequestMapping("api/plant/recommended")
@RestController
public class RecommendedPlantController {
    private final RecommendedPlantService recommendedplantService;

    @Autowired
    public RecommendedPlantController(RecommendedPlantService recommendedplantService) {
        this.recommendedplantService = recommendedplantService;
    }

    @PostMapping
    public void addPlant(@RequestBody RecommendedPlant plant) {
        recommendedplantService.addRecommendedPlant(plant);
    }

    @GetMapping
    public List<RecommendedPlant> getAllRecommendedPlants() {
        return recommendedplantService.getAllRecommendedPlants();
    }

    @GetMapping(path="{id}")
    public RecommendedPlant getRecommendedPlant(@PathVariable("id") UUID id) {
        return recommendedplantService.getRecommendedPlant(id)
            .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deleteRecommendedPlant(@PathVariable("id") UUID id) {
        recommendedplantService.deleteRecommendedPlant(id);
    }

    @PutMapping(path="{id}")
    public void updateRecommendedPlant(@PathVariable("id") UUID id, @RequestBody RecommendedPlant newPlant) {
        recommendedplantService.updateRecommendedPlant(id, newPlant);
    }

}