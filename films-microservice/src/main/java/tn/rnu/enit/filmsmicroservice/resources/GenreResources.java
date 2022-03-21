package tn.rnu.enit.filmsmicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rnu.enit.filmsmicroservice.Service.GenreService;
import tn.rnu.enit.filmsmicroservice.domain.Film;
import tn.rnu.enit.filmsmicroservice.domain.Genre;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class GenreResources {

    @Autowired
    private GenreService genreService;

    @GetMapping("/get-all-genres")
    public ResponseEntity<List<Genre>> getAllGenres(){
        return new ResponseEntity<>(genreService.getAllGenres(), HttpStatus.OK);
    }

    @GetMapping("/get-genre/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") Long id){
        return new ResponseEntity<>(genreService.getGenreById(id), HttpStatus.OK);
    }

    @PostMapping("create-genre")
    public ResponseEntity<Genre> createNewGenre(@RequestBody Genre genre){
        return new ResponseEntity<>(genreService.createGenre(genre), HttpStatus.CREATED);
    }

    @GetMapping("/find-genre-nom/{nomGenre}")
    public ResponseEntity<Genre> findByNomGenre(@PathVariable("nomGenre") String nomGenre){
        return new ResponseEntity<>(genreService.findByNomGenre(nomGenre), HttpStatus.OK);
    }

    @GetMapping("/find-genres-film")
    public ResponseEntity<List<Genre>> findGenresByFilm(@RequestBody Film film){
        return new ResponseEntity<>(genreService.findGenresByFilm(film), HttpStatus.OK);
    }
}
