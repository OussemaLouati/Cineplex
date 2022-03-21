package tn.rnu.enit.cinemamicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rnu.enit.cinemamicroservice.Dto.PlaceDeletedDTO;
import tn.rnu.enit.cinemamicroservice.Service.PlaceService;
import tn.rnu.enit.cinemamicroservice.domain.Place;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class PlaceResources {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/places-disponibles")
    public ResponseEntity<List<Place>> getPlacesByDisponible(){
        return new ResponseEntity<>(placeService.getPlacesByDisponible(), HttpStatus.OK);
    }

    @PostMapping("/create-place")
    public ResponseEntity<Place> createNewPlace(@RequestBody Place place){
        return new ResponseEntity<>(placeService.createPlace(place), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-place/{id}")
    public ResponseEntity<PlaceDeletedDTO> deletePlace(@PathVariable("id") Long id){
        return new ResponseEntity<>(placeService.deletePlace(id), HttpStatus.OK);
    }
}
