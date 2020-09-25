package xylembackend.search.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xylembackend.search.model.Plant;
import xylembackend.search.service.PlantService;

@RequestMapping("api/plant")
@RestController
public class PlantController {

    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping
    public void addPlant(@RequestBody Plant plant) {
        plantService.addPlant(plant);
    }

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping(path="{id}")
    public Plant getPlant(@PathVariable("id") UUID id) {
        return plantService.getPlant(id)
            .orElse(null);
    }

}