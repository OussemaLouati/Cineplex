package tn.rnu.enit.filmsmicroservice.Service;

import tn.rnu.enit.filmsmicroservice.domain.Film;
import tn.rnu.enit.filmsmicroservice.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
    Genre getGenreById(Long id);
    Genre createGenre(Genre genre);
    Genre findByNomGenre(String nomGenre);
    List<Genre> findGenresByFilm(Film film);
}
