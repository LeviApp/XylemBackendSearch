package xylembackend.search.api;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Id;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event.ID;

import xylembackend.search.model.Plant;
import xylembackend.search.repo.PlantRepo;
// import xylembackend.search.service.PlantService;
import xylembackend.search.service.PlantService;

@RestController
public class PlantController {

    @Autowired
    private PlantService plantService;

    // private UUID id;
    // private String userId;
    // private String commonName;

    // @Column(unique=true)
    // private String scientificName;

    // private String familyCommonName;
    // private String family;
    // private String genus;
    // private int year;
    // private String imageUrl;
    @PostMapping("/api/plant")
    public void addPlant(@RequestBody Plant plant) {
        plantService.addPlant(plant);
    }

    @GetMapping("/api/plant")
    public List<Plant> getAllPlants() {
      // This returns a JSON or XML with the users
      return plantService.getAllPlants();
    }

    @GetMapping("/api/plant/order/likes_{bool}_desc")
    public List<Plant> orderByLikesDesc(@PathVariable("bool") Boolean bool) {
      // This returns a JSON or XML with the users
      return plantService.orderByLikesDesc(bool);
    }

    @GetMapping("/api/plant/order/likes_{bool}_asc")
    public List<Plant> orderByLikesAsc(@PathVariable("bool") Boolean bool) {
      // This returns a JSON or XML with the users
      return plantService.orderByLikesAsc(bool);
    }

    @GetMapping("/api/plant/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable("id") Integer id) {
        try {
            Plant plant = plantService.getPlant(id);
            return new ResponseEntity<Plant>(plant, HttpStatus.OK);
        }

        catch(NoSuchElementException e) {
            return new ResponseEntity<Plant>(HttpStatus.NOT_FOUND);

        }
    }

    // @GetMapping("/api/plant/dislikegroup/{id}")
    // public ResponseEntity<Plant> getCombinedDislikedPlant(@PathVariable("id") Integer id) {
    //     try {
    //         Plant plant = plantService.getCombinedDislikedPlant(id);
    //         return new ResponseEntity<Plant>(plant, HttpStatus.OK);
    //     }

    //     catch(NoSuchElementException e) {
    //         return new ResponseEntity<Plant>(HttpStatus.NOT_FOUND);

    //     }
    // }

    // @DeleteMapping(path="{id}")
    // public void deletePlant(@PathVariable("id") Integer id) {
    //     plantRepo.deleteById(id);
    // }

    @PutMapping("/api/plant/{id}")
    public ResponseEntity<?> updatePlant(@RequestBody Plant newPlant, @PathVariable("id") Integer id) {
        try{
            plantService.deletePlant(id);
            plantService.addPlant(newPlant);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/api/plant/{id}")
    public void deletePlant(@PathVariable Integer id) {
        plantService.deletePlant(id);
    }

}