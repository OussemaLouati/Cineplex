package tn.rnu.enit.filmsmicroservice.Service;

import tn.rnu.enit.filmsmicroservice.Dto.FilmDeletedDTO;
import tn.rnu.enit.filmsmicroservice.domain.Film;
import tn.rnu.enit.filmsmicroservice.domain.Genre;

import java.util.Date;
import java.util.List;

public interface FilmService {
    List<Film> getAllFilms();
    Film getFilmById(Long id);
    Film updateFilm(Long id, Film film);
    Film createFilm(Film film);
    FilmDeletedDTO deleteFilm(Long id);
    Film getFilmByTitre(String titre);
    List<Film> findFilmsByGenre(Genre genre);
    List<Film> findFilmsByDateSortie(Date date);
}
