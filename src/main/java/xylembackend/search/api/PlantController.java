package xylembackend.search.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("api/plant")
public class PlantController {

    @Autowired

    private PlantRepo plantRepo;

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
    @PostMapping
    public @ResponseBody String addPlant(@RequestParam String userId, @RequestParam String commonName, @RequestParam String scientificName, @RequestParam String familyCommonName, @RequestParam String family, @RequestParam String genus,  @RequestParam int year,  @RequestParam String imageUrl) {
        Plant plant = new Plant();

        plant.setUserId(userId);
        plant.setCommonName(commonName);
        plant.setScientificName(scientificName);
        plant.setFamilyCommonName(familyCommonName);
        plant.setFamily(family);
        plant.setGenus(genus);
        plant.setYear(year);
        plant.setImageUrl(imageUrl);
        plantRepo.save(plant);
        return "Saved Plant";
    }

    @GetMapping
    public @ResponseBody Iterable<Plant> getAllPlants() {
      // This returns a JSON or XML with the users
      return plantRepo.findAll();
    }

    @GetMapping(path="{id}")
    public @ResponseBody Optional<Plant> getPlant(@PathVariable("id") Integer id) {
        return plantRepo.findById(id);
    }

    @DeleteMapping(path="{id}")
    public void deletePlant(@PathVariable("id") Integer id) {
        plantRepo.deleteById(id);
    }

    @PutMapping(path="{id}")
    public void updatePlant(Integer id, Plant newPlant) {
        plantRepo.save(newPlant);
    }

}