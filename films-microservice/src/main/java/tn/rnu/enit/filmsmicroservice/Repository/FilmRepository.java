package tn.rnu.enit.filmsmicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.rnu.enit.filmsmicroservice.domain.Film;
import tn.rnu.enit.filmsmicroservice.domain.Genre;

import java.util.Date;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findFilmByTitre(String titre);

    List<Film> findFilmsByDateSortie(String dateSortie);

    @Query("select f from Film f where :genre member of f.genres")
    List<Film> findFilmsByGenre(@Param("genre") Genre genre);
}
