package xylembackend.search.api;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xylembackend.search.model.Plant;
import xylembackend.search.model.RecommendedPlant;
import xylembackend.search.model.RecommendedPlantData;
import xylembackend.search.service.RecommendedPlantService;

@RestController
public class RecommendedPlantController {

    @Autowired
    private RecommendedPlantService recommendedplantService;

    @PostMapping("api/plant/recommended")
    public void addPlant(@RequestBody RecommendedPlant plant) {
        recommendedplantService.addRecommendedPlant(plant);
    }

    @GetMapping("api/plant/recommended")
    public List<RecommendedPlant> getAllRecommendedPlants() {
        return recommendedplantService.getAllRecommendedPlants();
    }


    @GetMapping("api/plant/recommended/{id}")
    public ResponseEntity<RecommendedPlant> getRecommendedPlant(@PathVariable("id") Integer id) {
        try {
            RecommendedPlant recommendedPlant = recommendedplantService.getRecommendedPlant(id);
            return new ResponseEntity<RecommendedPlant>(recommendedPlant, HttpStatus.OK);
        }

        catch(NoSuchElementException e) {
            return new ResponseEntity<RecommendedPlant>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("api/plant/recommended/list/{userid}")
    public List<Object> listRecommended(@PathVariable("userid") String userid) {
        return recommendedplantService.listRecommended(userid);
    }

    @PutMapping("api/plant/recommended/{id}")
    public ResponseEntity<?> updateRecommendedPlant(@RequestBody RecommendedPlant newRecommendedPlant, @PathVariable("id") Integer id) {
        try {
            recommendedplantService.deleteRecommendedPlant(id);
            recommendedplantService.addRecommendedPlant(newRecommendedPlant);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("api/plant/recommended/{id}")
    public void deleteRecommendedPlant(@PathVariable("id") Integer id) {
        recommendedplantService.deleteRecommendedPlant(id);
    }

}