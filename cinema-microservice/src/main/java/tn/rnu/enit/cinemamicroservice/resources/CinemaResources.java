package tn.rnu.enit.cinemamicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rnu.enit.cinemamicroservice.Dto.CinemaDeletedDTO;
import tn.rnu.enit.cinemamicroservice.Service.CinemaService;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.ShowingDetails;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class CinemaResources {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/get-programme-cinema/{nomCinema}")
    public ResponseEntity<List<ShowingDetails>> getProgramme(@PathVariable("nomCinema") String nomCinema){
        return new ResponseEntity<>(cinemaService.getCinemaByNom(nomCinema).getProgramme(), HttpStatus.OK);
    }

    @GetMapping("/get-all-cinemas")
    public ResponseEntity<List<Cinema>> getAllCinemas(){
        return new ResponseEntity<>(cinemaService.getAllCinemas(), HttpStatus.OK);
    }

    @GetMapping("/get-cinema/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cinemaService.getCinemaById(id), HttpStatus.OK);
    }

    @PutMapping("/update-cinema/{id}")
    public ResponseEntity<Cinema> updateCinema(@PathVariable("id") Long id, @RequestBody Cinema cinema) {
        return new ResponseEntity<>(cinemaService.updateCinema(id, cinema), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create-cinema/")
    public ResponseEntity<Cinema> createNewCinema(@RequestBody Cinema cinema) {
        return new ResponseEntity<>(cinemaService.createCinema(cinema), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-cinema/{id}")
    public ResponseEntity<CinemaDeletedDTO> deleteCinema(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cinemaService.deleteCinema(id), HttpStatus.OK);
    }

    @GetMapping("/find-cinema-nom/{nom}")
    public ResponseEntity<Cinema> getCinemaByNom(@PathVariable("nom") String nom) {
        return new ResponseEntity<>(cinemaService.getCinemaByNom(nom.trim().toLowerCase()), HttpStatus.OK);
    }

    @GetMapping("/find-cinemas-gouvernorat/{gouvernorat}")
    public ResponseEntity<List<Cinema>> findCinemasByGouvernorat(@PathVariable("gouvernorat") String gouvernorat) {
        return new ResponseEntity<>(cinemaService.findCinemasByGouvernorat(gouvernorat.trim().toLowerCase()), HttpStatus.OK);
    }
}
