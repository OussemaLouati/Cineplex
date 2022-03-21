package tn.rnu.enit.filmsmicroservice.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rnu.enit.filmsmicroservice.Repository.GenreRepository;
import tn.rnu.enit.filmsmicroservice.Service.GenreService;
import tn.rnu.enit.filmsmicroservice.domain.Film;
import tn.rnu.enit.filmsmicroservice.domain.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).isPresent() ? genreRepository.findById(id).get():null;
    }

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre findByNomGenre(String nomGenre) {
        return genreRepository.findByNomGenre(nomGenre);
    }

    @Override
    public List<Genre> findGenresByFilm(Film film) {
        return genreRepository.findGenresByFilm(film);
    }
}
