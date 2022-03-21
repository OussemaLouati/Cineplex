package tn.rnu.enit.cinemamicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rnu.enit.cinemamicroservice.Dto.ShowingDetailsDeletedDTO;
import tn.rnu.enit.cinemamicroservice.Service.ShowingDetailsService;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.Film;
import tn.rnu.enit.cinemamicroservice.domain.ShowingDetails;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ShowingDetailsResources {

    @Autowired
    private ShowingDetailsService showingDetailsService;

    @GetMapping("/get-all-showingdetails")
    public ResponseEntity<List<ShowingDetails>> getAllShowingDetails(){
        return new ResponseEntity<>(showingDetailsService.getAllShowingDetails(), HttpStatus.OK);
    }

    @GetMapping("/get-showingdetails/{id}")
    public ResponseEntity<ShowingDetails> getShowingDetailsById(@PathVariable("id") Long id){
        return new ResponseEntity<>(showingDetailsService.getShowingDetailsById(id), HttpStatus.OK);
    }

    /*@PutMapping("/update-showingdetails/{id}")
    public ResponseEntity<ShowingDetails> updateShowingDetails(@PathVariable("id") Long id, @RequestBody ShowingDetails showingDetails){
        return new ResponseEntity<>(showingDetailsService.updateShowingDetails(id,showingDetails), HttpStatus.ACCEPTED);
    }*/

    @PostMapping("/create-showingdetails/")
    public ResponseEntity<ShowingDetails> createNewShowingDetails(@RequestBody ShowingDetails showingDetails){
        return new ResponseEntity<>(showingDetailsService.createShowingDetails(showingDetails), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-showingdetails/{id}")
    public ResponseEntity<ShowingDetailsDeletedDTO> deleteShowingDetails(@PathVariable("id") Long id){
        return new ResponseEntity<>(showingDetailsService.deleteShowingDetails(id), HttpStatus.OK);
    }

    @GetMapping("/find-showingdetails-prix-between")
    public ResponseEntity<List<ShowingDetails>> getShowingDetailsByPrixTNDBetween(@RequestParam("startPrixTND") double startPrixTND, @RequestParam("endPrixTND") double endPrixTND){
        return new ResponseEntity<>(showingDetailsService.getShowingDetailsByPrixTNDBetween(startPrixTND,endPrixTND), HttpStatus.OK);
    }

    @GetMapping("/find-showingdetails-cinema/{nomCinema}")
    public ResponseEntity<List<ShowingDetails>> findShowingDetailsByNomCinema(@PathVariable("nomCinema") String nomCinema){
        return new ResponseEntity<>(showingDetailsService.findShowingDetailsByNomCinema(nomCinema), HttpStatus.OK);
    }

    @GetMapping("/find-showingdetails-film/{nomFilm}")
    public ResponseEntity<List<ShowingDetails>> findShowingDetailsByNomFilm(@PathVariable("nomFilm") String nomFilm){
        return new ResponseEntity<>(showingDetailsService.findShowingDetailsByNomFilm(nomFilm), HttpStatus.OK);
    }

    @GetMapping("/more-about-film")
    public ResponseEntity<Film> getFilmInfos(@RequestBody ShowingDetails showingDetails){
        return new ResponseEntity<>(showingDetailsService.getFilmInfos(showingDetails), HttpStatus.OK);
    }
}
