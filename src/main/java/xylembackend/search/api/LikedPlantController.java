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

import xylembackend.search.model.LikedPlant;
import xylembackend.search.service.LikedPlantService;

@RestController
public class LikedPlantController {

    @Autowired
    private LikedPlantService likedplantService;

    @PostMapping("api/plant/liked")
    public void addLikedPlant(@RequestBody LikedPlant likedplant) {
        likedplantService.addLikedPlant(likedplant);
    }

    @GetMapping("api/plant/liked")
    public List<LikedPlant> getAllLikedPlants() {
        return likedplantService.getAllLikedPlants();
    }

    @GetMapping("api/plant/liked/{id}")
    public ResponseEntity<LikedPlant> getLikedPlant(@PathVariable("id") Integer id) {
        try {
            LikedPlant likedPlant = likedplantService.getLikedPlant(id);
            return new ResponseEntity<LikedPlant>(likedPlant, HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<LikedPlant>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("api/plant/countliked/{id}")
    public Long getLikedPlantCount(@PathVariable("id") Integer id) {
            return likedplantService.countLikedPlant(id);
    }

    @GetMapping("api/plant/countdisliked/{id}")
    public Long getDislikedPlantCount(@PathVariable("id") Integer id) {
            return likedplantService.countDislikedPlant(id);
    }

    @DeleteMapping("api/plant/liked/{id}")
    public void deletePlant(@PathVariable("id") Integer id) {
        likedplantService.deleteLikedPlant(id);
    }

    @PutMapping("api/plant/liked/{id}")
    public ResponseEntity<?> updateLikedPlant(@RequestBody LikedPlant newLikedPlant, @PathVariable("id") Integer id) {
        try {
            likedplantService.deleteLikedPlant(id);
            likedplantService.addLikedPlant(newLikedPlant);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
        }
    }
}