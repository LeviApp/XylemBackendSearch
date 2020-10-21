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

import xylembackend.search.model.DislikedPlant;
import xylembackend.search.service.DislikedPlantService;

@RequestMapping("api/plant/disliked")
@RestController
public class DislikedPlantController {
    private final DislikedPlantService dislikedplantService;

    @Autowired
    public DislikedPlantController(DislikedPlantService dislikedplantService) {
        this.dislikedplantService = dislikedplantService;
    }

    @PostMapping
    public void addDislikedPlant(@RequestBody DislikedPlant plant) {
        dislikedplantService.addDislikedPlant(plant);
    }

    @GetMapping
    public List<DislikedPlant> getAllPlants() {
        return dislikedplantService.getAllDislikedPlants();
    }

    @GetMapping(path="{id}")
    public DislikedPlant getDislikedPlant(@PathVariable("id") UUID id) {
        return dislikedplantService.getDislikedPlant(id)
            .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deletePlant(@PathVariable("id") UUID id) {
        dislikedplantService.deleteDislikedPlant(id);
    }

    @PutMapping(path="{id}")
    public void updateDislikedPlant(@PathVariable("id") UUID id, @RequestBody DislikedPlant newDislikedPlant) {
        dislikedplantService.updateDislikedPlant(id, newDislikedPlant);
    }
}