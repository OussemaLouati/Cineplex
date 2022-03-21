package tn.rnu.enit.filmsmicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rnu.enit.filmsmicroservice.Dto.FilmDeletedDTO;
import tn.rnu.enit.filmsmicroservice.Service.FilmService;
import tn.rnu.enit.filmsmicroservice.domain.Film;
import tn.rnu.enit.filmsmicroservice.domain.Genre;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class FilmResources {

    @Autowired
    private FilmService filmService;

    @GetMapping("/get-all-films")
    public ResponseEntity<List<Film>> getAllFilms(){
        return new ResponseEntity<>(filmService.getAllFilms(), HttpStatus.OK);
    }

    @PostMapping("/create-film")
    public ResponseEntity<Film> createNewFilm(@RequestBody Film film) {
        return new ResponseEntity<>(filmService.createFilm(film), HttpStatus.CREATED);
    }

    @GetMapping("/get-film/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(filmService.getFilmById(id), HttpStatus.OK);
    }

    @PutMapping("/update-film/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable("id") Long id, @RequestBody Film film) {
        return new ResponseEntity<>(filmService.updateFilm(id, film), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-film/{id}")
    public ResponseEntity<FilmDeletedDTO> deleteFilm(@PathVariable("id") Long id) {
        return new ResponseEntity<>(filmService.deleteFilm(id), HttpStatus.OK);
    }

    @GetMapping("/find-film-titre/{titre}")
    public ResponseEntity<Film> getFilmByTitre(@PathVariable("titre") String titre) {
        return new ResponseEntity<>(filmService.getFilmByTitre(titre.trim().toLowerCase()), HttpStatus.OK);
    }

    @GetMapping("/find-film-releaseDate/{dateSortie}")
    public ResponseEntity<List<Film>> getFilmsByDateSortie(@PathVariable("dateSortie") @DateTimeFormat(pattern="dd-MM-yyyy") Date dateSortie) {
        return new ResponseEntity<>(filmService.findFilmsByDateSortie(dateSortie), HttpStatus.OK);
    }

    @GetMapping("/find-films-genre/{genre}")
    public ResponseEntity<List<Film>> getFilmsByGenre(@PathVariable("genre") Genre genre) {
        return new ResponseEntity<>(filmService.findFilmsByGenre(genre), HttpStatus.OK);
    }
}
