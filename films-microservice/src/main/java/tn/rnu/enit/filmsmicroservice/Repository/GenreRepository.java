package tn.rnu.enit.filmsmicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.rnu.enit.filmsmicroservice.domain.Film;
import tn.rnu.enit.filmsmicroservice.domain.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByNomGenre(String nomGenre);

    @Query("select g from Genre g where :film member of g.films")
    List<Genre> findGenresByFilm(@Param("film") Film film);
}
