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

import xylembackend.search.model.LikedPlant;
import xylembackend.search.service.LikedPlantService;

@RequestMapping("api/plant/liked")
@RestController
public class LikedPlantController {

    private final LikedPlantService likedplantService;

    @Autowired
    public LikedPlantController(LikedPlantService likedplantService) {
        this.likedplantService = likedplantService;
    }

    @PostMapping
    public void addLikedPlant(@RequestBody @Validated LikedPlant plant) {
        likedplantService.addLikedPlant(plant);
    }

    @GetMapping
    public List<LikedPlant> getAllPlants() {
        return likedplantService.getAllLikedPlants();
    }

    @GetMapping(path="{id}")
    public LikedPlant getLikedPlant(@PathVariable("id") UUID id) {
        return likedplantService.getLikedPlant(id)
            .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deletePlant(@PathVariable("id") UUID id) {
        likedplantService.deleteLikedPlant(id);
    }

    @PutMapping(path="{id}")
    public void updateLikedPlant(@PathVariable("id") UUID id, @RequestBody LikedPlant newLikedPlant) {
        likedplantService.updateLikedPlant(id, newLikedPlant);
    }
}