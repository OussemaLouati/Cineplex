package tn.rnu.enit.filmsmicroservice.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rnu.enit.filmsmicroservice.Dto.FilmDeletedDTO;
import tn.rnu.enit.filmsmicroservice.Repository.FilmRepository;
import tn.rnu.enit.filmsmicroservice.Service.FilmService;
import tn.rnu.enit.filmsmicroservice.domain.Film;
import tn.rnu.enit.filmsmicroservice.domain.Genre;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).isPresent() ? filmRepository.findById(id).get() : null;
    }

    @Override
    public Film updateFilm(Long id, Film film) {
        Optional<Film> filmDb= filmRepository.findById(id);
        Film filmToUpdate;
        if(filmDb.isPresent()) {
            filmToUpdate = filmDb.get();
            filmToUpdate.setTitre(film.getTitre());
            filmToUpdate.setSynopsis(film.getSynopsis());
            filmToUpdate.setPoster(film.getPoster());
            filmToUpdate.setDuree(film.getDuree());
            filmToUpdate.setDateSortie(film.getDateSortie());
            return filmRepository.save(filmToUpdate);
        }
        return null;
    }

    @Override
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public FilmDeletedDTO deleteFilm(Long id) {
        Film film = filmRepository.getOne(id);
        FilmDeletedDTO filmDeletedDTO = new FilmDeletedDTO();
        filmDeletedDTO.setId(id);
        filmDeletedDTO.setTitre(film.getTitre());
        filmDeletedDTO.setDeleted(true);
        filmRepository.deleteById(id);
        return filmDeletedDTO;
    }

    @Override
    public Film getFilmByTitre(String titre) {
        return filmRepository.findFilmByTitre(titre);
    }

    @Override
    public List<Film> findFilmsByGenre(Genre genre) {
        return filmRepository.findFilmsByGenre(genre);
    }

    @Override
    public List<Film> findFilmsByDateSortie(Date dateSortie) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(dateSortie);
        return filmRepository.findFilmsByDateSortie(date);
    }
}
